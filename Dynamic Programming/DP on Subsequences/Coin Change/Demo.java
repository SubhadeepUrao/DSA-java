class Solution {
    int coinChange(int[] coins, int i, int amount) {
        if(amount == 0) return 0;
        if(i < 0) return Integer.MAX_VALUE;

        int take = amount >= coins[i] ? coinChange(coins, i, amount-coins[i]) : Integer.MAX_VALUE;
        if(take != Integer.MAX_VALUE) ++take;

        int notTake = coinChange(coins, i-1, amount);

        return Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int N = coins.length;
        int res = coinChange(coins, N-1, amount);
        return res != Integer.MAX_VALUE ? res : -1;
    }
}