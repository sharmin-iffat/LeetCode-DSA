class Solution {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        sum(nums, ans,0, 0);
        return ans;
    }
    public void sum(int[] nums, int[] arr, int i, int remainingSum) {
        if(i == nums.length){
            return; 
        }
     
        arr[i] = nums[i] + remainingSum;

        remainingSum = arr[i];

        sum(nums, arr, i+1, remainingSum);;
    }
}