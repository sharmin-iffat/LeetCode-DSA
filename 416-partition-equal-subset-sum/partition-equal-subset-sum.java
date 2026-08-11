class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
        }
        if(sum%2 != 0) return false;

        int target = sum/2;
        Boolean[][] memo = new Boolean[n][target+1];

        return subSet(nums, target, 0, memo);
    }
    private boolean subSet(int[] nums, int target, int i, Boolean[][] memo){
        if(target == 0) return true;
        if(target != 0 && i == nums.length) return false;
        if(memo[i][target] != null) return memo[i][target];
        if(target >= nums[i]){
            boolean pick = subSet(nums, target-nums[i], i+1, memo);
            boolean skip = subSet(nums, target, i+1, memo);
            return memo[i][target] = pick || skip;
        }else{
            return memo[i][target] = subSet(nums, target, i+1, memo);
        }
    }
}