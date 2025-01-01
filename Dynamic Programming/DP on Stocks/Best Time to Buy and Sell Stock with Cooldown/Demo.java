class Solution {
    int maxProfit(int[] prices, int i, int buy) {
        if (i >= prices.length) return 0;

        if (buy == 1)
            return Math.max(maxProfit(prices, i + 1, 0) - prices[i], maxProfit(prices, i + 1, buy));
        return Math.max(maxProfit(prices, i + 2, 1) + prices[i], maxProfit(prices, i + 1, buy));
    }

    public int maxProfit(int[] prices) {
        return maxProfit(prices, 0, 1);
    }
}