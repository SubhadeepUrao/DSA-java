class Solution {
    int maxProfit(int[] prices, int i, int buy, int transaction) {
        if (transaction < 0 || i == prices.length) return 0;

        if (buy == 1)
            return Math.max(maxProfit(prices, i + 1, 0, transaction) - prices[i],
                    maxProfit(prices, i + 1, buy, transaction));
        return Math.max(maxProfit(prices, i + 1, 1, transaction - 1) + prices[i],
                maxProfit(prices, i + 1, buy, transaction));
    }

    public int maxProfit(int[] prices) {
        // valid_values(transaction) = [0, 1]
        // valid_values(buy) = [0, 1]
        return maxProfit(prices, 0, 1, 1);
    }
}