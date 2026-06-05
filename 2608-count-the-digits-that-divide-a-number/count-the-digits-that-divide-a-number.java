class Solution {
    int helper(int num, int q){
        if(q==0) return 0;
        int r = q % 10;
        if(r != 0 && num % r == 0){
            return 1 + helper(num, q/10);
        }else{
            return helper(num, q/10);
        }
    }
    public int countDigits(int num) {
        
        return helper(num, num);
    }
}
