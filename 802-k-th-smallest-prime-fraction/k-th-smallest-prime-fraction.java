class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(
                (double) arr[a[0]] / arr[a[1]],
                (double) arr[b[0]] / arr[b[1]])
        );

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                pq.add(new int[]{i, j});
            }
        }
        

        while(k != 1){
            pq.remove();
            k--;
        }
        int[] ans = pq.poll();

        return new int[] {arr[ans[0]], arr[ans[1]]};

    }
}