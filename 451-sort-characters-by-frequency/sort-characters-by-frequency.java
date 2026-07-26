class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(mp.get(b), mp.get(a))
        );

        for (char key : mp.keySet()) {
            pq.offer(key);
        }

        StringBuilder ans = new StringBuilder();

        while(pq.size() > 0){
            char ch = pq.poll();
            for (int i = 0; i < mp.get(ch); i++) {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}