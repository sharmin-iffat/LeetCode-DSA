class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] prefix = new int[n+1];
        
        prefix[0] = 0;
        int maxAlt = 0;
        for(int i=1; i<=n; i++){
            prefix[i] = gain[i-1] + prefix[i-1];

            maxAlt = Math.max(maxAlt, prefix[i]);
        }
        return maxAlt;
        
    }
}