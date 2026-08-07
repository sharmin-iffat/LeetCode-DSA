class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(
                nums1[a[0]] + nums2[a[1]],
                nums1[b[0]] + nums2[b[1]]
                
                )
        );

        for(int i=0; i<nums2.length; i++){
            pq.offer(new int[] {0, i});
        }
        List<List<Integer>> pairs = new ArrayList<>();

        while(k > 0 && !pq.isEmpty()){
            
            int i = pq.peek()[0];
            int j = pq.peek()[1];
            pq.poll();

            pairs.add(Arrays.asList(nums1[i], nums2[j]));
            
            k--;
            
            if(i+1<nums1.length){
                pq.offer(new int[]{i+1, j});
                
            }
        }
        return pairs;
    }
}