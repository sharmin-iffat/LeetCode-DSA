class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = Math.min(nums1.length, nums2.length);
        
        int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<>();

        for(int num:nums1){
            set.add(num);
        }
        int idx =0;
        for(int num:nums2){
            if(set.contains(num)){
                arr[idx++] = num;
                set.remove(num);
            }
        }
        return Arrays.copyOf(arr, idx);
    }
}