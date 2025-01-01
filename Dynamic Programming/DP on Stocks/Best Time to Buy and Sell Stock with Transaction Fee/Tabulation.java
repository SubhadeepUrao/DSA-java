class Solution {
    public int maxProfit(int[] prices, int fee) {
        int N = prices.length;
        int[][] dp = new int[N + 1][2];

        for (int i = N - 1; i >= 0; --i) {
            for (int j = 0; j < 2; ++j) {
                dp[i][j] = Math.max(dp[i + 1][j], j == 1 ? dp[i + 1][0] - prices[i] - fee : dp[i + 1][1] + prices[i]);
            }
        }

        return dp[0][1];
    }
}