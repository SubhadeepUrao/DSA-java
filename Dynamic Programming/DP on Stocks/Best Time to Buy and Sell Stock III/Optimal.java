class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[][] prev = new int[2][3];

        for (int i = N - 1; i >= 0; --i) { // index
            for (int j = 0; j <= 1; ++j) { // buy
                for (int k = 1; k <= 2; ++k) { // transaction
                    prev[j][k] = Math.max(prev[j][k],
                            j == 1 ? prev[0][k] - prices[i] : prev[1][k - 1] + prices[i]);
                }
            }
        }

        return prev[1][2];
    }
}