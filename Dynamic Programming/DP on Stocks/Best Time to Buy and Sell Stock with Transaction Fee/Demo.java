class Solution {
    int maxProfit(int[] prices, int fee, int i, int buy) {
        if (i == prices.length) return 0;

        if (buy == 1)
            return Math.max(maxProfit(prices, fee, i + 1, 0) - prices[i] - fee, maxProfit(prices, fee, i + 1, buy));
        return Math.max(maxProfit(prices, fee, i + 1, 1) + prices[i], maxProfit(prices, fee, i + 1, buy));
    }

    public int maxProfit(int[] prices, int fee) {
        return maxProfit(prices, fee, 0, 1);
    }
}