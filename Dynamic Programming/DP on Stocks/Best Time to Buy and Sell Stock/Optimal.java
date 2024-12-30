class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[] prev = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            for (int j = i; j <= N; ++j) {
                prev[j] = Math.max(prices[j - 1] - prices[i - 1], Math.max(prev[j], prev[j - 1]));
            }
        }
        return prev[N];
    }
}