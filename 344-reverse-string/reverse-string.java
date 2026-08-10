class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        reverse(s, 0, n-1);
    }
    private void reverse(char[] s, int l, int r) {
        if(l >= r){
            return;
        }
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;

        reverse(s, l+1, r-1);
    }
}