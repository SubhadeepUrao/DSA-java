class Solution {
    int maxProfit(int[] prices, int i, int buy, int k, Integer[][][] dp) {
        if (i == prices.length || k < 0) return 0;

        if (dp[i][buy][k] != null) return dp[i][buy][k];

        if (buy == 1)
            return dp[i][buy][k] = Math.max(maxProfit(prices, i + 1, 0, k, dp) - prices[i],
                    maxProfit(prices, i + 1, buy, k, dp));
        return dp[i][buy][k] = Math.max(maxProfit(prices, i + 1, 1, k - 1, dp) + prices[i],
                maxProfit(prices, i + 1, buy, k, dp));
    }

    public int maxProfit(int k, int[] prices) {
        int N = prices.length;
        Integer[][][] dp = new Integer[N][2][k];
        return maxProfit(prices, 0, 1, k - 1, dp);
    }
}