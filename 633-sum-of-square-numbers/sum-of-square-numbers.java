class Solution {
    public boolean judgeSquareSum(int c) {

        if(c <= 1) return true;
        int i=0, j= (int)Math.sqrt(c);

        while(i<=j){
            long num = 1L * i * i + 1L * j * j;
            if(num == c) return true;
            else if(num > c) j--;
            else i++;
        }
        return false;
    }
}