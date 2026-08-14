class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int len = 0;
        int l =0;

        for(int i=0; i<s.length(); i++){
            
            while(freq[s.charAt(i) - 'a'] >= 2){
                freq[s.charAt(l) - 'a']--;
                l++;
            }

            freq[s.charAt(i) - 'a']++;

            len = Math.max(len, i-l+1);
        }
        return len;
    }
}