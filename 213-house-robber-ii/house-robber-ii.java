class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int case1 = robLinear(nums, 0, n-2);
        int case2 = robLinear(nums, 1, n-1);
        
        return Math.max(case1, case2);

    }
    private int robLinear(int[] nums, int l, int r){
        int len = r - l + 1;
        int[] dp = new int[len];

        dp[0] = nums[l];

        if(len > 1) dp[1] = Math.max(nums[l], nums[l+1]);

        for(int i=2; i<len; i++){
            dp[i] = Math.max(dp[i-1], nums[l + i] + dp[i-2]);
        }
        return dp[len-1];
    }
}