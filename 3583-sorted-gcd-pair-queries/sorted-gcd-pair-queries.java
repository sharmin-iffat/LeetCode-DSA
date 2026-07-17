class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        long[] exact = new long[max + 1];
        int[] divisible = new int[max + 1];

        // Count numbers divisible by d
        for (int d = 1; d <= max; d++) {
            for (int m = d; m <= max; m += d) {
                divisible[d] += freq[m];
            }
        }

        // Inclusion-Exclusion
        for (int d = max; d >= 1; d--) {
            long cnt = divisible[d];
            exact[d] = cnt * (cnt - 1) / 2;

            for (int m = d + d; m <= max; m += d) {
                exact[d] -= exact[m];
            }
        }

        // Prefix counts
        long[] prefix = new long[max + 1];
        for (int d = 1; d <= max; d++) {
            prefix[d] = prefix[d - 1] + exact[d];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1; // 0-based index to rank

            int l = 1, r = max;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (prefix[mid] >= target)
                    r = mid;
                else
                    l = mid + 1;
            }

            ans[i] = l;
        }

        return ans;
    }
}