class Solution {
    static class SegmentTree {
        private final int n;
        private final char[] s;
        private final int[] maxLen;
        private final int[] prefLen;
        private final int[] suffLen;

        public SegmentTree(String str) {
            this.n = str.length();
            this.s = str.toCharArray();
            int sz = 4 * n;
            this.maxLen = new int[sz];
            this.prefLen = new int[sz];
            this.suffLen = new int[sz];
            build(1, 0, n - 1);
        }

        private void merge(int node, int start, int end, int leftChild, int rightChild) {
            int mid = start + (end - start) / 2;
            int leftLen = mid - start + 1;
            int rightLen = end - mid;

            // Default values from child segments
            maxLen[node] = Math.max(maxLen[leftChild], maxLen[rightChild]);
            prefLen[node] = prefLen[leftChild];
            suffLen[node] = suffLen[rightChild];

            // If characters match across the boundary, merge across mid
            if (s[mid] == s[mid + 1]) {
                maxLen[node] = Math.max(maxLen[node], suffLen[leftChild] + prefLen[rightChild]);

                if (prefLen[leftChild] == leftLen) {
                    prefLen[node] = leftLen + prefLen[rightChild];
                }
                if (suffLen[rightChild] == rightLen) {
                    suffLen[node] = rightLen + suffLen[leftChild];
                }
            }
        }

        private void build(int node, int start, int end) {
            if (start == end) {
                maxLen[node] = 1;
                prefLen[node] = 1;
                suffLen[node] = 1;
                return;
            }
            int mid = start + (end - start) / 2;
            int left = 2 * node;
            int right = 2 * node + 1;

            build(left, start, mid);
            build(right, mid + 1, end);
            merge(node, start, end, left, right);
        }

        public void update(int node, int start, int end, int idx, char ch) {
            if (start == end) {
                s[idx] = ch;
                return;
            }
            int mid = start + (end - start) / 2;
            int left = 2 * node;
            int right = 2 * node + 1;

            if (idx <= mid) {
                update(left, start, mid, idx, ch);
            } else {
                update(right, mid + 1, end, idx, ch);
            }
            merge(node, start, end, left, right);
        }

        public int getMax() {
            return maxLen[1];
        }
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        SegmentTree tree = new SegmentTree(s);
        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            tree.update(1, 0, s.length() - 1, idx, ch);
            ans[i] = tree.getMax();
        }

        return ans;
    }
}