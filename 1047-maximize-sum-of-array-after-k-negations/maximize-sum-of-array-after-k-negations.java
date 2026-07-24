class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n && k > 0; i++){
            if(nums[i] < 0){
                nums[i] = -nums[i];
                k--;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int num: nums){
            min = Math.min(min, num);
        }
        int sum = 0;
        for(int num: nums){
            sum += num;
        }

        if(k % 2 == 1){
            sum -= 2*min;
        }
        return sum;
    }
}