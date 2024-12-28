class Solution {
    static int knapSack(int[] val, int[] wt, int i, int capacity, Integer[][] dp) {
        if (capacity == 0 || i < 0) return 0;

        if (dp[i][capacity] != null) return dp[i][capacity];

        if (capacity >= wt[i])
            return dp[i][capacity] = Math.max(knapSack(val, wt, i, capacity - wt[i], dp) + val[i],
                    knapSack(val, wt, i - 1, capacity, dp));
        return dp[i][capacity] = knapSack(val, wt, i - 1, capacity, dp);
    }

    static int knapSack(int val[], int wt[], int capacity) {
        int N = val.length;
        Integer[][] dp = new Integer[N][capacity + 1];
        return knapSack(val, wt, N - 1, capacity, dp);
    }
}