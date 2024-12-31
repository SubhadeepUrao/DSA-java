class Solution {
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        // profit[i] = max profit using remaining trades after i
        int[] profit = new int[n];
        for (int t = 1; t <= k; t++) {
            int top = prices[n - 1];
            int best = 0;
            for (int i = n - 1; i >= 0; i--) {
                top = Math.max(top, prices[i] + profit[i]);
                best = Math.max(best, top - prices[i]);
                profit[i] = best;
            }
        }

        return profit[0];
    }
}