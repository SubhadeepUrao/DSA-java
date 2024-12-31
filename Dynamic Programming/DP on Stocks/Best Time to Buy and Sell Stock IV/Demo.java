class Solution {
    int maxProfit(int[] prices, int i, int buy, int k) {
        if (i == prices.length || k < 0) return 0;

        if (buy == 1)
            return Math.max(maxProfit(prices, i + 1, 0, k) - prices[i], maxProfit(prices, i + 1, buy, k));
        return Math.max(maxProfit(prices, i + 1, 1, k - 1) + prices[i], maxProfit(prices, i + 1, buy, k));
    }

    public int maxProfit(int k, int[] prices) {
        return maxProfit(prices, 0, 1, k - 1);
    }
}