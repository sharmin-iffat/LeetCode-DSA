class Solution {
    public char findTheDifference(String s, String t) {
        int[] freq = new int[26];

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            freq[ch - 'a']++;
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);

            if(freq[ch - 'a'] == 0){
                return ch;
            }else{
                freq[ch - 'a']--;
            }
        }
        return 'a';

    }
}