class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++){
            pq.offer(stones[i]);
        }
        
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            if(a != b){
                pq.offer(Math.abs(b-a));
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}