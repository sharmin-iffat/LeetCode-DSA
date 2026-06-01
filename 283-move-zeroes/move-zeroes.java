class Solution {
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void moveZeroes(int[] nums) {
        int i=0;
        int j =1; 
        while(i<j && j<nums.length){
            

            if(nums[i] == 0 && nums[j] !=0){
                swap(nums, i, j);
            }else if(nums[i] != 0){
                i++;
                j++;
            }else{
                j++;
            }
        }
    }
}