class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = Math.min(nums1.length, nums2.length);
        int[] ans = new int[n];

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0, j=0, k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                if(k == 0){
                    ans[k++] = nums1[i];
                }else if(k != 0 && nums1[i] != ans[k-1]){
                    ans[k++] = nums1[i];
                }
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOf(ans, k);
        
    }
}