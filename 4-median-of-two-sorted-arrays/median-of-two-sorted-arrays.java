class Solution {
    int[] merge(int[] num1, int[] num2){
        int p = num1.length-1;
        int q = num2.length-1;
        int n = num1.length +  num2.length;

        int[] arr = new int[n];
        int i = 0, j =0, k=0;

        while(i<=p && j<=q){
            if(num1[i]<= num2[j]){
                arr[k] = num1[i];
                i++;
            }else{
                arr[k] = num2[j];
                j++;
            }
            k++;
        }
        while(i<=p){
            arr[k++] = num1[i++];
        }
        while(j<=q){
            arr[k++] = num2[j++];
        }
        return arr;
        
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       
       int[] arr = merge(nums1, nums2);

       int n = arr.length;

       if (n % 2 != 0) {
            return arr[n / 2];
        } else {
            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        }

        
    }
}