class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[] prev = new int[2];
        int prev2 = 0;

        for (int i = N - 1; i >= 0; --i) {
            int temp = prev[1];
            for (int j = 0; j < 2; ++j) {
                prev[j] = Math.max(prev[j], j == 1 ? prev[0] - prices[i] : prev2 + prices[i]);
            }
            prev2 = temp;
        }
        return prev[1];
    }
}