class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        if(grid[M-1][N-1] == 1 || grid[0][0] == 1) return 0;

        int[] dp = new int[N];
        dp[0] = 1; // bottom-right is reachable
        
        for(int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        
        return dp[N - 1];
    }

    // public int uniquePathsWithObstacles(int[][] grid) {
    //     int M = grid.length;
    //     int N = grid[0].length;

    //     if(grid[M-1][N-1] == 1) return 0;

    //     int[] dp = new int[N];
    //     dp[N-1] = 1; // bottom-right is reachable
    //     for(int i = N-2; i >= 0; --i)
    //         if(grid[M-1][i] == 0) dp[i] += dp[i+1];
        
    //     for(int i = M-2; i >= 0; --i) {
    //         if(grid[i][N-1] == 1) dp[N-1] = 0;
    //         for(int j = N-2; j >= 0; --j) {
    //             if(grid[i][j] == 0) dp[j] += dp[j+1];
    //             else dp[j] = 0;
    //         }
    //     }
    //     return dp[0];
    // }
}