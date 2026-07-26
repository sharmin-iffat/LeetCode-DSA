class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int num:nums){
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
        (a,b) -> Integer.compare(mp.get(a), mp.get(b)));

        for (int key : mp.keySet()) {
            pq.offer(key);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans  = new int[k];

        for(int i=0; i<k; i++){
            ans[i] = pq.remove();
        }
        return ans;
        
    }
}