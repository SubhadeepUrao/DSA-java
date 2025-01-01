class Solution {
    public int maxProfit(int[] prices, int fee) {
        int N = prices.length;
        int prev0 = 0, prev1 = 0;

        for (int i = N - 1; i >= 0; --i) {
            prev0 = Math.max(prev0, prev1 + prices[i]);
            prev1 = Math.max(prev1, prev0 - prices[i] - fee);
        }

        return prev1;
    }
}