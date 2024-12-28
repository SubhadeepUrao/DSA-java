class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] prev = new int[amount + 1];
        
        for (int j = 1; j <= amount; ++j)
            prev[j] = Integer.MAX_VALUE;
        
        for (int coin : coins) {
            for (int j = coin; j <= amount; ++j) {
                if (prev[j - coin] != Integer.MAX_VALUE) {
                    prev[j] = Math.min(prev[j], prev[j - coin] + 1);
                }
            }
        }

        return prev[amount] == Integer.MAX_VALUE ? -1 : prev[amount];
    }
}