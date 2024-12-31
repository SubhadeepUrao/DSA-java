class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[][][] dp = new int[N + 1][2][3];

        for (int i = N - 1; i >= 0; --i) { // index
            for (int j = 0; j <= 1; ++j) { // buy
                for (int k = 1; k <= 2; ++k) { // transaction
                    dp[i][j][k] = Math.max(dp[i + 1][j][k],
                            j == 1 ? dp[i + 1][0][k] - prices[i] : dp[i + 1][1][k - 1] + prices[i]);
                }
            }
        }

        return dp[0][1][2];
    }
}