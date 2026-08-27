import java.util.Arrays;

public class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int matchedLen = 0;
        while (matchedLen < n && freq[target.charAt(matchedLen) - 'a'] > 0) {
            freq[target.charAt(matchedLen) - 'a']--;
            matchedLen++;
        }

        for (int k = matchedLen; k >= 0; k--) {
            if (k < matchedLen) {
                freq[target.charAt(k) - 'a']++;
            }
            
            if (k < n) {
                int targetCharIdx = target.charAt(k) - 'a';
                
                for (int c = targetCharIdx + 1; c < 26; c++) {
                    if (freq[c] > 0) {
                        
                        freq[c]--;
                        
                        
                        StringBuilder result = new StringBuilder();
                        result.append(target, 0, k);
                        result.append((char) ('a' + c));
                        
                        for (int remainChar = 0; remainChar < 26; remainChar++) {
                            while (freq[remainChar] > 0) {
                                result.append((char) ('a' + remainChar));
                                freq[remainChar]--;
                            }
                        }
                        
                        return result.toString();
                    }
                }
            }
        }

        return "";
    }
}