class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<nums.length; i++){
            pq.add(nums[i]);
        }
        int a = pq.remove();
        int b = pq.remove();

        return (a-1) * (b-1);
    }
}