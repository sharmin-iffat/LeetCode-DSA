class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m+n];
       
        int l=0, r=0, i=0;
        while(l<m && r<n){
            if(nums1[l] <= nums2[r]){
                ans[i] = nums1[l];
                l++;
                i++;
            }else{
                ans[i] = nums2[r];
                r++;
                i++;
            }
        }
        while (l < m) {
            ans[i++] = nums1[l++];
        }
        while (r < n) {
            ans[i++] = nums2[r++];
        }

        for(int j=0; j<m+n; j++){
            nums1[j] = ans[j];
        }
    }
}