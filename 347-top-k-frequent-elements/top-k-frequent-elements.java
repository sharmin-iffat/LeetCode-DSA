class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[nums.length];

        HashMap<Integer, Integer> mp = new HashMap<>();
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.get(1), a.get(1))
        );

        for(int num : nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        while(mp.size() > 0){
            ArrayList<Integer> list = new ArrayList<>();
            int key = mp.keySet().iterator().next();
            int value = mp.get(key);
            list.add(key);
            list.add(value);
            pq.add(list);
            mp.remove(key);
        }

        int idx = 0;
        int i =0;
        while(k != 0){
            ArrayList<Integer> list = pq.remove();
            int val = list.get(i);
            ans[idx++] = val;
            k--;
        }
        return Arrays.copyOf(ans, idx);
    }
}