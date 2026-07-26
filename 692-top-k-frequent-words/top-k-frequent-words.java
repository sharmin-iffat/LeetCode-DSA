class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> mp = new HashMap<>();

        for(String s : words){
            mp.put(s, mp.getOrDefault(s, 0)+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
            (a,b) -> {
                if (mp.get(a).equals(mp.get(b))) {
                    return a.compareTo(b);
                }
                return Integer.compare(mp.get(b), mp.get(a));
            }
        );

         for (String word : mp.keySet()) {
            pq.offer(word);
        }
        
        ArrayList<String> ans = new ArrayList<>();

        while(k>0){
            ans.add(pq.poll());
            k--;
        }

        return ans;
    }
}