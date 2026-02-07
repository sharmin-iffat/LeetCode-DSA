class Solution {
    public int minimumDeletions(String s) {
        int bCount = 0;
        int deletion =0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'b'){
                bCount++;
            }else{
                deletion = Math.min(deletion +1, bCount);
            }
        }
        return deletion;
    }
}