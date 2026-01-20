class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        int lo=0; 
        int hi = nums.length-1;

        while(lo<=hi){
            int mid = lo + (hi-lo)/2;

            if(nums[mid] == target){
                ans[0] = mid;
                hi = mid-1;
            }
            else if(nums[mid] < target) lo = mid+1;
            else hi= mid-1;
        }
        lo = 0; 
        hi = nums.length - 1;

        while(lo<=hi){
            int mid = lo + (hi-lo)/2;

            if(nums[mid] == target){
                ans[1] = mid;
                lo = mid+1;
            }
            else if(nums[mid] < target) lo = mid+1;
            else hi= mid-1;
        }

        return ans;
    }
}