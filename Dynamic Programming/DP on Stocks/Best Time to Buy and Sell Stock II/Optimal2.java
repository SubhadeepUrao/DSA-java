class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[] prev = new int[N + 1];

        for (int j = 0; j < N; ++j)
            prev[j] = prices[0] < prices[j] ? prices[j] - prices[0] : 0;

        for (int i = 1; i <= N; ++i) {
            for (int j = i; j <= N; ++j) {
                int profit = Math.max(prev[j - 1], prev[j]);
                prev[j] = Math.max(profit,
                        prices[i - 1] < prices[j - 1] ? prices[j - 1] - prices[i - 1] + prev[i - 1] : 0);
            }
        }
        return prev[N];
    }
}