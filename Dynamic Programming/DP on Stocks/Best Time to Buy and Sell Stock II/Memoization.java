class Solution {
    int maxProfit(int[] prices, int i, int buy, Integer[][] dp) {
        if (i == prices.length) return 0;

        if (dp[i][buy] != null) return dp[i][buy];

        if (buy == 1)
            return dp[i][buy] = Math.max(maxProfit(prices, i + 1, 0, dp) - prices[i],
                    maxProfit(prices, i + 1, buy, dp));
        return dp[i][buy] = Math.max(maxProfit(prices, i + 1, 1, dp) + prices[i], maxProfit(prices, i + 1, buy, dp));
    }

    public int maxProfit(int[] prices) {
        int N = prices.length;
        Integer[][] dp = new Integer[N][2];

        return maxProfit(prices, 0, 1, dp);
    }
}