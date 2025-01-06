class Solution {
    public int countSquares(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;

        int[][] dp = new int[N][M];
        int cnt = 0;

        for (int i = 0; i < N; ++i) {
            if (matrix[i][0] == 1) {
                ++cnt;
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < M; ++j) {
            if (matrix[0][j] == 1) {
                ++cnt;
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < N; ++i) {
            for (int j = 1; j < M; ++j) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    cnt += dp[i][j];
                }
            }
        }
        return cnt;
    }
}