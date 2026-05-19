class Solution {
    public int sumOfUnique(int[] nums) {
       Arrays.sort(nums);
       int sum =0;
       int i=0;
       int j=1;
       while(i < nums.length){
        
        while(j < nums.length && nums[i] == nums[j]){
            j++;
        }
        if(j == i+1){
            sum +=nums[i];
        }

        i = j;
        j= i+1;

       }
       return sum;
    }
}

         