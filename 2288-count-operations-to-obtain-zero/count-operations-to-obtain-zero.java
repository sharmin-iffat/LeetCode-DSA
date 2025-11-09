class Solution {
    public int countOperations(int num1, int num2) {
        int max=Math.max(num1, num2);
        int count =0;
        for(int i=1; i<=max; i++){
            int mx=Math.max(num1, num2);
            if(num1 ==0 || num2==0){
                return count;
            }
            else if(mx==num1){
                num1 = num1-num2;
                count++;
            }else{
                num2 = num2- num1;
                count++;
            }
        }
        return count;
    }
}