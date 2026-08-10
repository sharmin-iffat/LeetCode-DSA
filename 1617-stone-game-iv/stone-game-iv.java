class Solution {
    public boolean winnerSquareGame(int n) {
        Boolean[] dp = new Boolean[n + 1];
        return solve(n, dp);
    }

    private boolean solve(int n, Boolean[] dp) {
        if (n == 0) {
            return false;
        }

        if (dp[n] != null) {
            return dp[n];
        }

        // Try taking every possible perfect square
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;

            // If opponent loses after our move,
            // then current player wins.
            if (!solve(n - square, dp)) {
                return dp[n] = true;
            }
        }

        return dp[n] = false;
    }
}