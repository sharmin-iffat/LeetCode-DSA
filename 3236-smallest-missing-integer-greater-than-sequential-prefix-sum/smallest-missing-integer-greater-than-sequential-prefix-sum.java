class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int sum = nums[0];

        for(int i=1; i<n; i++){
            if(nums[i] != nums[i-1]+1){
                break;
            }
            sum += nums[i];
        }
        Arrays.sort(nums);

        for(int i=0; i<n; i++){
            if(nums[i] == sum) sum +=1;
        }
        return sum;
    }
}