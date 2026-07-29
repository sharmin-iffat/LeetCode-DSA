
class Solution {
    // Cap to prevent overflow since k <= 10^6
    private static final long MAX_K = 1_000_000 + 1;

    public String smallestPalindrome(String s, int k) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        int[] halfCount = new int[26];
        char midChar = 0;
        int halfLen = 0;

        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
            halfLen += halfCount[i];
            if (count[i] % 2 != 0) {
                midChar = (char) ('a' + i);
            }
        }

        // Check if there are at least k valid palindromic permutations
        long totalPermutations = countArrangements(halfCount);
        if (k > totalPermutations) {
            return "";
        }

        StringBuilder leftHalf = new StringBuilder();

        // Construct the left half character by character
        for (int step = 0; step < halfLen; step++) {
            for (int i = 0; i < 26; i++) {
                if (halfCount[i] == 0) continue;

                halfCount[i]--;
                long arrangements = countArrangements(halfCount);

                if (arrangements >= k) {
                    leftHalf.append((char) ('a' + i));
                    break; // Found the character for this position
                } else {
                    k -= arrangements;
                    halfCount[i]++; // Backtrack and try next character
                }
            }
        }

        // Build the full palindrome
        StringBuilder rightHalf = new StringBuilder(leftHalf).reverse();
        if (midChar != 0) {
            return leftHalf.toString() + midChar + rightHalf.toString();
        } else {
            return leftHalf.toString() + rightHalf.toString();
        }
    }

    // Calculates multinomial permutations for current character frequencies
    private long countArrangements(int[] count) {
        int total = 0;
        for (int freq : count) {
            total += freq;
        }

        long res = 1;
        for (int freq : count) {
            if (freq == 0) continue;
            res = multiply(res, nCk(total, freq));
            total -= freq;
            if (res >= MAX_K) {
                return MAX_K;
            }
        }
        return res;
    }

    // Calculates combinations n choose k with overflow capping
    private long nCk(int n, int k) {
        if (k > n - k) k = n - k;
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
            if (res >= MAX_K) return MAX_K;
        }
        return res;
    }

    private long multiply(long a, long b) {
        if (a == 0 || b == 0) return 0;
        if (a >= MAX_K || b >= MAX_K) return MAX_K;
        long res = a * b;
        return res >= MAX_K ? MAX_K : res;
    }
}