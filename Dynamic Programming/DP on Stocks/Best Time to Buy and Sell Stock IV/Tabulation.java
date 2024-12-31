class Solution {
    public int maxProfit(int k, int[] prices) {
        int N = prices.length;
        int[][][] dp = new int[N + 1][2][k + 1];

        for (int i = N - 1; i >= 0; --i) {
            for (int j = 0; j <= 1; ++j) {
                for (int t = 1; t <= k; ++t) {
                    dp[i][j][t] = Math.max(dp[i + 1][j][t],
                            j == 1 ? dp[i + 1][0][t] - prices[i] : dp[i + 1][1][t - 1] + prices[i]);
                }
            }
        }
        return dp[0][1][k];
    }
}