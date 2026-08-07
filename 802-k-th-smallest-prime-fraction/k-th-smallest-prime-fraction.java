class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(
                (double) arr[a[0]] / arr[a[1]],
                (double) arr[b[0]] / arr[b[1]])
        );

        for(int i=0; i<arr.length; i++){
            pq.add(new int[]{0, i});
            
        }
        

        while(--k > 0){
            int i = pq.peek()[0];
            int j = pq.poll()[1];

            if(i+1 < j){
                pq.offer(new int[]{i+1, j});
            }
           
        }
        int[] ans = pq.poll();

        return new int[] {arr[ans[0]], arr[ans[1]]};

    }
}