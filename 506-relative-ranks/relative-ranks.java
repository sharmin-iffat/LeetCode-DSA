class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));

        for(int i=0; i<n; i++){
            pq.offer(new int[]{i, score[i]});
        }

        ans[pq.poll()[0]] = "Gold Medal";
        if(!pq.isEmpty()) ans[pq.poll()[0]] = "Silver Medal";
        if(!pq.isEmpty()) ans[pq.poll()[0]] = "Bronze Medal";

        while(!pq.isEmpty()){
            int pos = n - pq.size() + 1;
            ans[pq.poll()[0]] = Integer.toString(pos);
        }
        return ans;
    }
}