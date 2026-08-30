class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n <= 1) return n;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxIdx = -1;
        int minIdx = -1;

        for(int i=0; i<n; i++){
            if(nums[i]> max){
                max = nums[i];
                maxIdx = i;
            }
            if(nums[i] < min){
                min = nums[i];
                minIdx = i;
            }
        }

       int left = Math.min(maxIdx, minIdx);
       int right = Math.max(maxIdx, minIdx);

       int fromLeft = right + 1;
       int fromRight = n-left;
       int fromBoth = (left + 1) + (n - right);

       return Math.min(fromBoth, Math.min(fromLeft, fromRight));
        
    }
}