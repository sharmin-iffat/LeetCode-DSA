class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        int[] suffix = new int[n+1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }

        for(int i=0; i<n; i++){
            if(prefix[i] == suffix[i+1]){
                return i;
            } 
        }
        return -1;
    }
}