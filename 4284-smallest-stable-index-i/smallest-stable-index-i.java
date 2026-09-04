class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] maxArr = new int[n];
        int[] minArr = new int[n];

        maxArr[0] = nums[0];

        for (int i = 1; i < n; i++) {
            maxArr[i] = Math.max(maxArr[i - 1], nums[i]);
        }

        minArr[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            minArr[i] = Math.min(minArr[i + 1], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            int diff = maxArr[i] - minArr[i];

            if (diff <= k) {
                return i;
            }
        }

        return -1;
    }
}