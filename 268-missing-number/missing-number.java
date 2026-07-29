class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int currSum = 0;

        for(int i=0; i<n; i++){
            currSum += nums[i];
            totalSum += i;
        }
        totalSum += n;

        return totalSum - currSum;
        
    }
}