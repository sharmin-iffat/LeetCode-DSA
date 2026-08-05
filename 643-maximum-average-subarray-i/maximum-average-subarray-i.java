class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0;
        double maxAvg = Integer.MIN_VALUE;
        int l = 0;
        int r =0;

        for(r =0; r<k; r++){
            sum += nums[r];
        }
        double avg = sum/k;
        maxAvg = Math.max(maxAvg, avg);

        for(r=k; r<n; r++){
            sum -= nums[l++];
            sum += nums[r];
            avg = sum/k;
            maxAvg = Math.max(maxAvg, avg);
        }
        return maxAvg;
    }
}