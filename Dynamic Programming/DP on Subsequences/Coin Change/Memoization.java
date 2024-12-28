class Solution {
    int coinChange(int[] coins, int i, int amount, Integer[][] dp) {
        if(amount == 0) return 0;
        if(i < 0) return Integer.MAX_VALUE;

        if(dp[i][amount] != null) return dp[i][amount];

        int take = amount >= coins[i] ? coinChange(coins, i, amount-coins[i], dp) : Integer.MAX_VALUE;
        if(take != Integer.MAX_VALUE) ++take;

        int notTake = coinChange(coins, i-1, amount, dp);

        return dp[i][amount] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int N = coins.length;
        Integer[][] dp = new Integer[N][amount + 1];

        int res = coinChange(coins, N - 1, amount, dp);
        return res != Integer.MAX_VALUE ? res : -1;
    }
}