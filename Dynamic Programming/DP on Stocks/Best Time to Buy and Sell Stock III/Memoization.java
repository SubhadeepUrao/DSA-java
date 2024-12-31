class Solution {
    int maxProfit(int[] prices, int i, int buy, int transaction, Integer[][][] dp) {
        if (transaction < 0 || i == prices.length) return 0;

        if(dp[i][buy][transaction] != null) return dp[i][buy][transaction];

        if (buy == 1)
            return dp[i][buy][transaction] = Math.max(maxProfit(prices, i + 1, 0, transaction, dp) - prices[i],
                    maxProfit(prices, i + 1, buy, transaction, dp));
        return dp[i][buy][transaction] = Math.max(maxProfit(prices, i + 1, 1, transaction - 1, dp) + prices[i],
                maxProfit(prices, i + 1, buy, transaction, dp));
    }

    public int maxProfit(int[] prices) {
        int N = prices.length;
        Integer[][][] dp = new Integer[N][2][2];
        return maxProfit(prices, 0, 1, 1, dp);
    }
}