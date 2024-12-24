class Solution {
    public int uniquePaths(int M, int N) {
        int[][] dp = new int[M][N];

        for(int i = 0; i < N; ++i)
            dp[M-1][i] = 1;
        for(int i = 0; i < M; ++i)
            dp[i][N-1] = 1;

        for(int i = M-2; i >= 0; --i) {
            for(int j = N-2; j >= 0; --j) {
                int right = dp[i][j+1];
                int down = dp[i+1][j];
                dp[i][j] = right + down;
            }
        }
        return dp[0][0];
    }

    // public int uniquePaths(int M, int N) {
    //     int[][] dp = new int[M][N];
    //     dp[M-1][N-1] = 1;

    //     for(int i = M-1; i >= 0; --i) {
    //         for(int j = N-1; j >= 0; --j) {
    //             if(i == M-1 && j == N-1) continue;
    //             int right = j+1 < N ? dp[i][j+1] : 0;
    //             int down = i+1 < M ? dp[i+1][j] : 0;
    //             dp[i][j] = right + down;
    //         }
    //     }
    //     return dp[0][0];
    // }
}