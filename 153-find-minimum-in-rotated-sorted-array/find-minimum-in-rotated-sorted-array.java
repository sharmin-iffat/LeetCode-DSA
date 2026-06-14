
class Solution {
    public int findMin(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
        }
        return pq.peek();
    }
}