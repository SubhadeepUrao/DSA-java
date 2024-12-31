class Solution {
    public int maxProfit(int k, int[] prices) {
        int N = prices.length;
        int[][] prev = new int[2][k + 1];

        for (int i = N - 1; i >= 0; --i) {
            for (int j = 0; j <= 1; ++j) {
                for (int t = 1; t <= k; ++t) {
                    prev[j][t] = Math.max(prev[j][t],
                            j == 1 ?prev[0][t] - prices[i] : prev[1][t - 1] + prices[i]);
                }
            }
        }
        return prev[1][k];
    }
}