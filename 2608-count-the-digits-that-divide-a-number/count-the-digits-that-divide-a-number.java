class Solution {
    public int countDigits(int num) {
        int count =0;
        int q = num;
        while(q != 0){
            int r = q%10;
            q /=10;
            if(r != 0 && num % r == 0) count++;
        }
        return count;
        
    }
}
