class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        // dp[i] = maximum number of palindromes using first i characters
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];

            // Odd length palindrome ending at i-1
            for (int len = k; len <= i; len++) {
                if (isPalindrome(s, i - len, i - 1)) {
                    dp[i] = Math.max(dp[i], dp[i - len] + 1);
                    break;
                }
            }
        }

        return dp[n];
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}