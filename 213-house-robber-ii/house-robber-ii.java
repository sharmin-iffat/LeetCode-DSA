class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);

        int[] dp1 = new int[3];
        int[] dp2 = new int[3];

        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[2], nums[1]);

        for(int i=2; i<n-1; i++){
            dp1[2] = Math.max(dp1[1], dp1[0]+ nums[i]);
            dp1[0] = dp1[1];
            dp1[1] = dp1[2];
        }
        for(int i=2; i<n-1; i++){
            dp2[2] = Math.max(dp2[1], dp2[0]+ nums[i+1]);
            dp2[0] = dp2[1];
            dp2[1] = dp2[2];
        }
        return Math.max(dp1[1], dp2[1]);

    }
}