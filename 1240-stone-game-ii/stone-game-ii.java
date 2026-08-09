class Solution {

    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        // Build suffix sum
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return helper(0, 1);
    }

    private int helper(int i, int M) {

        // All remaining piles can be taken
        if (i >= n) {
            return 0;
        }

        if (2 * M >= n - i) {
            return suffix[i];
        }

        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int opponent = Integer.MAX_VALUE;

        for (int X = 1; X <= 2 * M && i + X <= n; X++) {

            int nextM = Math.max(M, X);

            int result = helper(i + X, nextM);

            opponent = Math.min(opponent, result);
        }

        dp[i][M] = suffix[i] - opponent;

        return dp[i][M];
    }
}