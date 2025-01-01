class Solution {
    public int maxProfit(int[] prices, int fee) {
        int N = prices.length;
        int[] prev = new int[2];

        for (int i = N - 1; i >= 0; --i) {
            for (int j = 0; j < 2; ++j) {
                prev[j] = Math.max(prev[j], j == 1 ? prev[0] - prices[i] - fee : prev[1] + prices[i]);
            }
        }

        return prev[1];
    }
}