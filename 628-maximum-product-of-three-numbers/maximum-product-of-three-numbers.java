class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int ans1 = nums[0] * nums[1] * nums[n-1];
        int ans2 = nums[n-3] * nums[n-2] * nums[n-1];

        int max = Math.max(ans1, ans2);

       
        return max;
        
    }
}