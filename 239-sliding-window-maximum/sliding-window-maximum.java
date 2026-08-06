class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1) return nums;
        int n = nums.length;
        
        int[] ans = new int[n-k+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(b[1], a[1]));

        int i=0, j=0, l=0;
        while(j < n){
            pq.offer(new int[]{j, nums[j]});

            if(j >= k-1){

                while (pq.peek()[0] < i) {
                    pq.poll();
                }
                
                ans[l++] = pq.peek()[1];
                i++;
            }

            j++;
        }
        return ans;

    }
}