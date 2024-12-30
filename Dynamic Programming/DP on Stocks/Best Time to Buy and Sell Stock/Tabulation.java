class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; ++i) {
            for (int j = i; j <= N; ++j) {
                dp[i][j] = Math.max(prices[j - 1] - prices[i - 1], Math.max(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[N][N];
    }
}