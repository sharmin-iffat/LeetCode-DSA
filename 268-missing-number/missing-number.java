class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int i=0;

        while (i < n) {
            int idx = nums[i];

            if (nums[i] < n && nums[i] != nums[idx]) {
                swap(i, idx, nums);
            } else {
                i++;
            }
        }
        for(int j=0; j<n; j++){
            if(nums[j] != j) return j;
        }
        return n;
    }
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}

        
