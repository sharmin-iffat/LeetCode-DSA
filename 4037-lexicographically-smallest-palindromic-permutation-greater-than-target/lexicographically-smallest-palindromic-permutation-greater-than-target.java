
class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Validate odd counts for palindrome feasibility
        int oddCount = 0;
        int middle = -1;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                oddCount++;
                middle = i;
            }
        }

        if (oddCount > 1) {
            return "";
        }

        int halfLen = n / 2;
        int[] halfFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        // Iterate backwards: find the longest prefix matching target[0...i-1]
        for (int i = halfLen; i >= 0; i--) {
            int[] curHalf = halfFreq.clone();
            boolean validPrefix = true;
            char[] prefix = new char[halfLen];

            // 1. Try to match prefix target[0...i-1]
            for (int k = 0; k < i; k++) {
                char tChar = target.charAt(k);
                if (curHalf[tChar - 'a'] > 0) {
                    prefix[k] = tChar;
                    curHalf[tChar - 'a']--;
                } else {
                    validPrefix = false;
                    break;
                }
            }

            if (!validPrefix) continue;

            // Case 1: Exact prefix match up to halfLen; test the full palindrome directly
            if (i == halfLen) {
                String candidate = buildFullPalindrome(prefix, middle);
                if (candidate.compareTo(target) > 0) {
                    return candidate;
                }
                continue;
            }

            // Case 2: Diverge at position i with a character strictly larger than target[i]
            int startChar = target.charAt(i) - 'a' + 1;
            for (int c = startChar; c < 26; c++) {
                if (curHalf[c] > 0) {
                    prefix[i] = (char) ('a' + c);
                    curHalf[c]--;

                    // Fill remaining positions greedily with smallest available characters
                    int idx = i + 1;
                    for (int ch = 0; ch < 26; ch++) {
                        while (curHalf[ch] > 0) {
                            prefix[idx++] = (char) ('a' + ch);
                            curHalf[ch]--;
                        }
                    }

                    String candidate = buildFullPalindrome(prefix, middle);
                    if (candidate.compareTo(target) > 0) {
                        return candidate;
                    }
                    break;
                }
            }
        }

        return "";
    }

    private String buildFullPalindrome(char[] left, int middle) {
        StringBuilder sb = new StringBuilder();
        sb.append(left);
        if (middle != -1) {
            sb.append((char) ('a' + middle));
        }
        for (int i = left.length - 1; i >= 0; i--) {
            sb.append(left[i]);
        }
        return sb.toString();
    }
}