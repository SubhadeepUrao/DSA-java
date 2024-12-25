class Solution {
    public int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] dp = new int[M][N];

        for(int i = 1; i < M; ++i)
            dp[i][0] += dp[i-1][0];
        for(int j = 1; j < N; ++j)
            dp[0][j] += dp[0][j-1];
        
        for(int i = 1; i < M; ++i) {
            for(int j = 1; j < N; ++j) {
                dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
            }
        }

        return dp[M-1][N-1];
    }
}