class Solution {
    public int maxProfit(int[] prices) {
        int buyCost = prices[0];
        int profit = 0;
        for (int i = 1 ; i < prices.length ; i++) {
            if (profit < prices[i] - buyCost) {
                profit = prices[i] - buyCost;
            }
            if (buyCost > prices[i]) {
                buyCost = prices[i];
            }
        }
        return profit;
    }
}