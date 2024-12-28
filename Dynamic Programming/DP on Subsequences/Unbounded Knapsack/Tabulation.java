class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        int N = val.length;
        int[][] dp = new int[N + 1][capacity + 1];

        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= capacity; ++j) {
                dp[i][j] = j >= wt[i - 1] ? Math.max(dp[i][j - wt[i - 1]] + val[i - 1], dp[i - 1][j]) : dp[i - 1][j];
            }
        }
        return dp[N][capacity];
    }
}