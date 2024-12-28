class Solution {
    public int change(int amount, int[] coins) {
        int[] prev = new int[amount + 1];

        prev[0] = 1;

        for (int coin : coins) {
            // In the coin change problem, you are counting combinations where each coin can
            // be used any number of times.
            // Forward iteration is required to ensure that you correctly include
            // combinations with repeated use of the same coin.
            for (int j = coin; j <= amount; --j) {
                prev[j] += prev[j - coin];
            }
        }

        return prev[amount];
    }
}