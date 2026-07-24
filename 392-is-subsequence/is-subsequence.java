class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int n = sArr.length;
        int m = tArr.length;
        int i=0, j=0;

        while(i<n && j<m){
            if(sArr[i] == tArr[j]){
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        if(i==n) return true;

        return false;
    }
}