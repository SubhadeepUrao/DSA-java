class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int[] next = new int[2];

        for (int i = N - 1; i >= 0; --i) {
            for (int j = 0; j <= 1; ++j) {
                next[j] = Math.max(j == 1 ? next[0] - prices[i] : next[1] + prices[i], next[j]);
            }
        }

        return next[1];
    }

    // public int maxProfit(int[] prices) {
    //     int N = prices.length;
    //     int next0 = 0, next1 = 0;

    //     for (int i = N - 1; i >= 0; --i) {
    //         next0 = Math.max(next1 + prices[i], next0);
    //         next1 = Math.max(next0 - prices[i], next1);
    //     }

    //     return next1;
    // }
}