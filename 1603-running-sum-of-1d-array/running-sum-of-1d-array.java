class Solution {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        sum(nums, ans, nums.length-1);
        return ans;
    }
    public int sum(int[] nums, int[] arr, int i) {
        if(i < 0){
            return 0; 
        }
        
        int remainingSum =  sum(nums, arr, i-1);
        arr[i] = nums[i] + remainingSum;

        return arr[i];
    }
}