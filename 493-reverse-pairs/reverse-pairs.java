class Solution {
    static int count;
    public int reversePairs(int[] nums) {
        count = 0;
        mergeSort(nums);
        return count;
    }
    private void mergeSort(int[] nums){
        int n = nums.length;
        if(n == 1) return;

        int[] a = new int[n/2];
        int[] b = new int[n - n/2];
        int idx = 0;
        for(int i=0; i<a.length; i++){
            a[i] = nums[idx++];
        }
        for(int i=0; i<b.length; i++){
            b[i] = nums[idx++];
        }
        mergeSort(a);
        mergeSort(b);
        inversion(a, b);
        merge(a,b,nums);
    }
    private void inversion(int[]a, int[] b){
        int i=0, j=0;
        while(i<a.length && j<b.length){
            if((long)a[i] > (long)2*(long)b[j]){
                count += (a.length - i);
                j++;
            }else{
                i++;
            }
        }
    }
    private void merge(int[] a, int[] b, int[] nums){
        int i=0, j=0, k=0;

        while(i<a.length && j<b.length){
            if(a[i] <= b[j]){
                nums[k++] = a[i++];
            }else{
                
                nums[k++] = b[j++];
            }
        }
        while(i<a.length) nums[k++] = a[i++];
        while(j<b.length) nums[k++] = b[j++];
    }
}