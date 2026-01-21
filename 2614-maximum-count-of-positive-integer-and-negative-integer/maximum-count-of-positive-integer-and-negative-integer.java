class Solution {
    public int maximumCount(int[] nums) {
        int pCount =0;
        int nCount = 0;
        int n = nums.length;
        int lo =0;
        int hi = nums.length -1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;

            if(nums[mid]>=0){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        nCount = lo;

        lo =0;
        hi=nums.length-1;

        while(lo<=hi){
            int mid = lo + (hi-lo)/2;

            if(nums[mid]<=0){
                lo=mid+1;
               
            }else{
                hi=mid-1;
            }
        }
        pCount = n-hi-1;

        return Math.max(nCount, pCount);
    }
}