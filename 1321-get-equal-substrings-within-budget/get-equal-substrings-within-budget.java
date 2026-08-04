class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] cost = new int[n];
        
        int count = 0;
        int currCount = 0;

        for(int i=0; i<n; i++){
            int diff = Math.abs(s.charAt(i) - t.charAt(i));
            cost[i] = diff;
        }
        int sum = 0;
        int l =0;
        for(int i=0; i<n; i++){
            sum += cost[i];

            while(sum > maxCost){
                
                sum -= cost[l];
                l++;
            }
            count = Math.max(count, i - l + 1);
            
        }

        return count;
        
    }
}