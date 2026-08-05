class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = prices[0];
        int profit = 0;

        for(int i=1; i<n; i++){
            if(prices[i] < prices[i-1]){
                profit += prices[i-1] - buy;
                buy = prices[i];
            }
        }
        profit += prices[n-1] - buy;

        return profit;
    }
}