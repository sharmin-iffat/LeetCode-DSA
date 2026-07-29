class Solution {
    public void wiggleSort(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int n = sorted.length;

        int left = (n-1)/2;
        int right = n-1;

        for(int i=1; i<n; i+=2){
            nums[i] = sorted[right--];
        }
        for(int i=0; i<n; i+=2){
            nums[i] = sorted[left--];
        }
    }
}