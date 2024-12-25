class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int N = matrix.length;
        int[][] dp = new int[N][N];

        for(int j = 0; j < N; ++j)
            dp[N-1][j] = matrix[N-1][j];

        for(int i = N-2; i >= 0; --i) {
            for(int j = 0; j < N; ++j) {
                int bottomLeft = j > 0 ? dp[i+1][j-1] : Integer.MAX_VALUE;
                int bottom = dp[i+1][j];
                int bottomRight = j < N-1 ? dp[i+1][j+1] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(bottomLeft, Math.min(bottom, bottomRight)) + matrix[i][j];
            }
        }

        int sum = Integer.MAX_VALUE;
        for(int j = 0; j < N; ++j)
            sum = Math.min(sum, dp[0][j]);
        
        return sum;
    }

    // public int minFallingPathSum(int[][] matrix) {
    //     int N = matrix.length;
    //     int[][] dp = new int[N][N];

    //     --N;
    //     for(int j = 0; j <= N; ++j)
    //         dp[N][j] = matrix[N][j];

    //     for(int i = N-1; i >= 0; --i) {
    //         for(int j = 0; j <= N; ++j) {
    //             int bottomLeft = j > 0 ? dp[i+1][j-1] : Integer.MAX_VALUE;
    //             int bottom = dp[i+1][j];
    //             int bottomRight = j < N ? dp[i+1][j+1] : Integer.MAX_VALUE;
    //             dp[i][j] = Math.min(bottomLeft, Math.min(bottom, bottomRight)) + matrix[i][j];
    //         }
    //     }

    //     int sum = Integer.MAX_VALUE;
    //     for(int j = 0; j <= N; ++j)
    //         sum = Math.min(sum, dp[0][j]);
        
    //     return sum;
    // }
}