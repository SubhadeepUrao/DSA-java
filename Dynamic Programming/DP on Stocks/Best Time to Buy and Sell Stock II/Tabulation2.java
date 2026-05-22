class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[][] dp = new int[N + 1][N + 1];

        for (int j = 0; j < N; ++j)
            dp[0][j] = prices[0] < prices[j] ? prices[j] - prices[0] : 0;

        for (int i = 1; i <= N; ++i) {
            for (int j = i; j <= N; ++j) {
                int profit = Math.max(dp[i][j - 1], dp[i - 1][j]);
                dp[i][j] = Math.max(profit,
                        prices[i - 1] < prices[j - 1] ? prices[j - 1] - prices[i - 1] + dp[i - 1][i - 1] : 0);
            }
        }
        return dp[N][N];
    }
}