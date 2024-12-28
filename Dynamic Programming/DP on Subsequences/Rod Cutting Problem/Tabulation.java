class Solution {
    public int cutRod(int[] price) {
        int N = price.length;
        int[][] dp = new int[N + 1][N + 1];
        int length = N;

        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= length; ++j) {
                dp[i][j] = j >= i ? Math.max(dp[i][j - i] + price[i - 1], dp[i - 1][j]) : dp[i - 1][j];
            }
        }
        return dp[N][N];
    }
}
