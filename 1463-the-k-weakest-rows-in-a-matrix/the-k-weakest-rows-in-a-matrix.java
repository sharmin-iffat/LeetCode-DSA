class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        );

        for(int i=0; i<m; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1) count++;
            }
            pq.offer(new int[]{i, count});
        }
        int[] ans = new int[k];
        int i=0;
        while(k != 0){
            ans[i++] = pq.poll()[0];
            k--;
        }
        return ans;
    }
}