class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int pro = 1;
        int [] ans = new int[n];
        int count=0;
        for(int i=0; i<n; i++){
            if(nums[i] != 0){
                pro *= nums[i];
            }else{
                count++;
            }
        }
        for(int i=0; i<n; i++){
            if(count > 1){
                ans[i] = 0;
            }else if(count == 1){
                ans[i] = (nums[i] == 0)? pro:0;
            }else{
                ans[i] = pro/nums[i];
            }
        }
        return ans;
    }
}