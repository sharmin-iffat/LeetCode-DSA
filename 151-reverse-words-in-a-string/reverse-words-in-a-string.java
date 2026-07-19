class Solution {
    public String reverseWords(String s) {
        s = s.trim(); 
        StringBuilder ans = new StringBuilder();

        int r = s.length()-1;
        int l = r;

        while(l>=0){
            
            while(l>=0 && s.charAt(l) != ' '){
                l--;
            }
            ans.append(s.substring(l+1, r+1));

            while(l>= 0 && s.charAt(l) == ' '){
                l--;
            }
            if(l>=0){
                ans.append(' ');
            }
            r= l;
        }
        return ans.toString();
    }
}