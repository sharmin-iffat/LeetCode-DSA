class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy  = prices[0];
        int[] dp = new int[n];

        for(int i=1; i<n; i++){
            if(buy > prices[i]){
                buy = prices[i];
                dp[i] = dp[i - 1];
            }else{
                dp[i] = Math.max(prices[i]-buy, dp[i-1]);
            }
        }
        
        return dp[n-1];
    }
}