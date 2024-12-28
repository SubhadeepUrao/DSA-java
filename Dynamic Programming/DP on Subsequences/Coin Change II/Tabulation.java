class Solution {
    public int change(int amount, int[] coins) {
        int N = coins.length;
        int[][] dp = new int[N + 1][amount + 1];

        for (int i = 0; i <= N; ++i)
            dp[i][0] = 1;

        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= amount; ++j) {
                dp[i][j] = j >= coins[i - 1] ? dp[i][j - coins[i - 1]] + dp[i - 1][j] : dp[i - 1][j];
            }
        }

        return dp[N][amount];
    }
}