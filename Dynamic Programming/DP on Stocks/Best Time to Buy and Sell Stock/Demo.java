class Solution {
    int maxProfit(int[] prices, int i, int j) {
        if (i > j || i < 0 || j < 0) return 0;

        return Math.max(prices[j] - prices[i], Math.max(maxProfit(prices, i - 1, j), maxProfit(prices, i, j - 1)));
    }

    public int maxProfit(int[] prices) {
        int N = prices.length;
        return maxProfit(prices, N - 1, N - 1);
    }
}