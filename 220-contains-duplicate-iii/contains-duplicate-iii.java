import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        TreeSet<Long> window = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            // Find the smallest number >= nums[i] - valueDiff
            Long candidate = window.ceiling((long) nums[i] - valueDiff);

            if (candidate != null && candidate <= (long) nums[i] + valueDiff) {
                return true;
            }

            window.add((long) nums[i]);

            // Keep window size at most indexDiff
            if (window.size() > indexDiff) {
                window.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}