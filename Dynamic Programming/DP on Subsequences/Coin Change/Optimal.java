class Solution {
    public int coinChange(int[] coins, int amount) {
        int N = coins.length;
        int[] prev = new int[amount + 1];

        for(int j = 1; j <= amount; ++j)
            prev[j] = Integer.MAX_VALUE;
        
        int[] curr = new int[amount + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= amount; ++j) {
                int take = j >= coins[i - 1] ? curr[j - coins[i - 1]] : Integer.MAX_VALUE;
                if (take != Integer.MAX_VALUE)
                    ++take;

                int notTake = prev[j];

                curr[j] = Math.min(take, notTake);
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[amount] != Integer.MAX_VALUE ? prev[amount] : -1;
    }
}