class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;
        double maxAvg = Integer.MIN_VALUE;

        int i=0, j=0;
        double sum = 0;
        
        for(j=0; j<k; j++){
            sum += nums[j];
        }
        double avg = sum/k;

        maxAvg = Math.max(maxAvg, avg);

        while(j<nums.length){
            

            sum -= nums[i];
            i++;
            sum+= nums[j];
            j++;

            avg = sum/k;

            maxAvg = Math.max(maxAvg, avg);
        }
        return maxAvg;
        
    }
}