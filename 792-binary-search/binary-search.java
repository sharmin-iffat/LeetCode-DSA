class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }
    private int helper(int[]arr, int t, int l, int h){
        if(l > h) return -1;

        int mid = l + (h-l)/2;

        if(arr[mid] == t) return mid;
        else if(arr[mid] > t) return helper(arr, t, l, mid-1);
        else return helper(arr, t, mid+1, h);
    }
}