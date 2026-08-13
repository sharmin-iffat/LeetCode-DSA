class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        int n = prices.length;
        int m = discounts.length;
        double amount = 0;
        Arrays.sort(prices);
        Arrays.sort(discounts);

        int i = n-1;

        for(int j=m-1; j>=0 && i>=0; j--){
            amount += (double)prices[i] * (100 - discounts[j])/ 100;
            i--;
        }

        while(i>=0){
            amount += (double)(prices[i]);
            i--;
        }
        return amount;
    }
}