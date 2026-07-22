

class Solution {

    static class Group {
        int start;
        int end;
        int length;

        Group(int start, int end) {
            this.start = start;
            this.end = end;
            this.length = end - start + 1;
        }
    }

    // Sparse Table for O(1) Range Maximum Queries
    static class SparseTable {
        private final int[][] st;

        public SparseTable(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                st = new int[0][0];
                return;
            }

            int logN = 32 - Integer.numberOfLeadingZeros(n);
            st = new int[logN][n];

            System.arraycopy(nums, 0, st[0], 0, n);

            for (int i = 1; i < logN; i++) {
                int halfLen = 1 << (i - 1);
                for (int j = 0; j + (1 << i) <= n; j++) {
                    st[i][j] = Math.max(st[i - 1][j], st[i - 1][j + halfLen]);
                }
            }
        }

        public int query(int l, int r) {
            if (l > r) return 0;
            int length = r - l + 1;
            int k = 31 - Integer.numberOfLeadingZeros(length);
            return Math.max(st[k][l], st[k][r - (1 << k) + 1]);
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int totalOnes = 0;
        
        // 1. Base amount of '1's in the whole string
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') totalOnes++;
        }

        // 2. Identify all '0'-groups
        List<Group> groups = new ArrayList<>();
        int start = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (start == -1) start = i;
            } else {
                if (start != -1) {
                    groups.add(new Group(start, i - 1));
                    start = -1;
                }
            }
        }
        if (start != -1) {
            groups.add(new Group(start, n - 1));
        }

        // 3. Populate adjacent group sums and build Sparse Table
        int m = groups.size();
        int[] adjSums = new int[Math.max(0, m - 1)];
        for (int i = 0; i < m - 1; i++) {
            adjSums[i] = groups.get(i).length + groups.get(i + 1).length;
        }

        SparseTable st = new SparseTable(adjSums);
        ArrayList<Integer> ans = new ArrayList<>();

        // 4. Resolve queries
        for (int q = 0; q < queries.length; q++) {
            int l = queries[q][0];
            int r = queries[q][1];

            int u = -1, v = -1;
            
            // Binary search for 'u' (first group intersecting window)
            int low = 0, high = m - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (groups.get(mid).end >= l) {
                    u = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Binary search for 'v' (last group intersecting window)
            low = 0; high = m - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (groups.get(mid).start <= r) {
                    v = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            // If there's 1 or 0 groups in the window, no trade is possible
            if (u == -1 || v == -1 || u >= m || v < 0 || u >= v) {
                ans.add(totalOnes);
            } else {
                int maxInc = 0;
                if (u + 1 == v) {
                    // Only two groups intersect, calculate max directly
                    maxInc = lenInWin(u, l, r, groups) + lenInWin(v, l, r, groups);
                } else {
                    // Left Boundary Check
                    maxInc = lenInWin(u, l, r, groups) + groups.get(u + 1).length;
                    
                    // Right Boundary Check
                    maxInc = Math.max(maxInc, groups.get(v - 1).length + lenInWin(v, l, r, groups));
                    
                    // Inner Query Full Valid Groups using Sparse Table in O(1)
                    if (u + 1 <= v - 2) {
                        maxInc = Math.max(maxInc, st.query(u + 1, v - 2));
                    }
                }
                ans.add(totalOnes + maxInc);
            }
        }
        
        return ans;
    }

    // Helper: Finds the active length of a 0-group heavily truncated by the query bounds [l, r]
    private int lenInWin(int i, int l, int r, List<Group> groups) {
        Group g = groups.get(i);
        return Math.max(0, Math.min(r, g.end) - Math.max(l, g.start) + 1);
    }
}