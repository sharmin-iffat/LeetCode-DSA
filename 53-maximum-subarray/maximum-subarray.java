class Solution {
    public int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int Max = nums[0];

        for(int i=1; i<nums.length; i++){
            currMax = Math.max(nums[i], currMax + nums[i]);
            Max = Math.max(Max, currMax);
        }
        return Max;
    }
}