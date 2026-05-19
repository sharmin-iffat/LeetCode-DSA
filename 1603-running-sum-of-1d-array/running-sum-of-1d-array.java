class Solution {
    public int[] runningSum(int[] nums) {
        int n= nums.length;
        int[] arr = new int[n];
        int currSum =0;
        for(int i=0; i<n; i++){
            currSum +=nums[i];

            arr[i] = currSum;
        }
        return arr;
        
    }
}