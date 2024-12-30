class Solution {
    int maxProfit(int[] prices, int i, int j, Integer[][] dp) {
        if (i > j || i < 0 || j < 0) return 0;

        if (dp[i][j] != null) return dp[i][j];

        return dp[i][j] = Math.max(prices[j] - prices[i],
                Math.max(maxProfit(prices, i - 1, j, dp), maxProfit(prices, i, j - 1, dp)));
    }

    public int maxProfit(int[] prices) {
        int N = prices.length;
        Integer[][] dp = new Integer[N][N];
        return maxProfit(prices, N - 1, N - 1, dp);
    }
}