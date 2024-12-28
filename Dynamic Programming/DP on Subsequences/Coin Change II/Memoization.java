class Solution {
    int change(int[] coins, int i, int amount, Integer[][] dp) {
        if(amount == 0) return 1;
        if(i < 0 || amount < 0) return 0;

        if(dp[i][amount] != null) return dp[i][amount];

        return dp[i][amount] = change(coins, i, amount - coins[i], dp) + change(coins, i - 1, amount, dp);
    }

    public int change(int amount, int[] coins) {
        int N = coins.length;
        Integer[][] dp = new Integer[N][amount + 1];
        return change(coins, N - 1, amount, dp);
    }
}