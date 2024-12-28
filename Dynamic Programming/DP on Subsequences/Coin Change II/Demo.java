class Solution {
    int change(int[] coins, int i, int amount) {
        if(amount == 0) return 1;
        if(i < 0 || amount < 0) return 0;

        return change(coins, i, amount - coins[i]) + change(coins, i - 1, amount);
    }

    // int change(int[] coins, int i, int amount) {
    //     if(amount == 0) return 1;
    //     if(i < 0) return 0;

    //     if (amount >= coins[i])
    //         return change(coins, i, amount - coins[i]) + change(coins, i - 1, amount);
    //     return change(coins, i - 1, amount);
    // }

    public int change(int amount, int[] coins) {
        int N = coins.length;
        return change(coins, N - 1, amount);
    }
}