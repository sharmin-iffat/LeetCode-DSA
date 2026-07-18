class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]); 
        }
        return gcd(min, max);
        
    }

    private int gcd(int a, int b){
        int temp = -1;
        while(temp != 0){
            temp = b%a; 
            b = a;
            a = temp;
        }
        return b;
    }
}