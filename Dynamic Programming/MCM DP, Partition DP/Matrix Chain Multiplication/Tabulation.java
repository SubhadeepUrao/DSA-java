class Solution {
    static int matrixMultiplication(int arr[]) {
        int N = arr.length;
        int[][] dp = new int[N][N];

        for (int i = N - 1; i >= 0; --i) {
            for (int j = i + 2; j < N; ++j) {
                int mini = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++k) {
                    mini = Math.min(mini, dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                }
                dp[i][j] = mini;
            }
        }
        return dp[0][N - 1];
    }
}