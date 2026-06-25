class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int val : stones){
            maxHeap.add(val);
        }
        
        while(maxHeap.size() > 1){
            int x = maxHeap.remove();
            int y = maxHeap.remove();
            if(x != y){
                maxHeap.add(Math.abs(y - x));
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}