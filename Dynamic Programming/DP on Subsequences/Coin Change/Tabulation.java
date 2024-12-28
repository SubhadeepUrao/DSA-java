class Solution {
    public int coinChange(int[] coins, int amount) {
        int N = coins.length;
        int[][] dp = new int[N + 1][amount + 1];

        for(int j = 1; j <= amount; ++j)
            dp[0][j] = Integer.MAX_VALUE;
        
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= amount; ++j) {
                int take = j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : Integer.MAX_VALUE;
                if (take != Integer.MAX_VALUE)
                    ++take;

                int notTake = dp[i - 1][j];

                dp[i][j] = Math.min(take, notTake);
            }
        }

        return dp[N][amount] != Integer.MAX_VALUE ? dp[N][amount] : -1;
    }
}