class Solution {
    public int numberOfSteps(int num) {
        return helper(num, 0);
    }
    int helper(int num, int steps){
        if(num == 0) return steps;

        if(num % 2 == 0){
            num = num/2;
        }else{
            num = num-1;
        }
        return helper(num, steps + 1);
    }
}