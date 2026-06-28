class Solution {
    public int[] productExceptSelf(int[] nums) {
        int count = 0;
        int prod = 1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) count++;
            else prod *= nums[i];
        }
        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if(count > 1) arr[i] = 0;
            else if(count == 1){
                if(nums[i] == 0) arr[i] = prod;
                else arr[i] = 0;
            }else{
                arr[i] = prod/nums[i];
            }
        }
        return arr;
    }
}