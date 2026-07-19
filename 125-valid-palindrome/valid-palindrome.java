class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = new char[s.length()];
        int k=0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if (!Character.isLetterOrDigit(ch))
                continue;


            if(ch >= 'A' && ch <= 'Z'){
                ch = (char)(ch+32);
            }
            arr[k++] = ch;
        }

        int l =0, r= k-1;

        while(l<r){
            if(arr[l] != arr[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
        
    }
}