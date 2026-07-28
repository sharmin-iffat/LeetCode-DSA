class Solution {
    public String smallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] freq = new int[26];

        for(int i=0; i<n; i++){
            freq[arr[i] - 'a']++;
        }
        
        char[] ans = new char[n];
        int k =0;

        for(int i=0; i<26; i++){
            for(int j = 0; j < freq[i] / 2; j++){
                ans[k++] = (char)(i + 'a');
            }                  
        }

        if (n % 2 == 1) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] % 2 == 1) {
                    ans[k++] = (char) (i + 'a');
                    break;
                }
            }
        }

        
        for (int i = n / 2 - 1; i >= 0; i--) {
            ans[k++] = ans[i];
        }
       
        return new String(ans);
        
    }
}