import java.util.Arrays;

class Solution {
    int minPathSum(int i, int j, int[][] grid, int[][] dp) {
        
        if(i == 0 && j == 0) return dp[i][j] = grid[0][0];
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int left = j > 0 ? minPathSum(i, j-1, grid, dp) : Integer.MAX_VALUE;
        int up = i > 0 ? minPathSum(i-1, j, grid, dp) : Integer.MAX_VALUE;

        return dp[i][j] = Math.min(left, up) + grid[i][j];
    }
    public int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[][] dp = new int[M][N];
        for(int i = 0; i < M; ++i)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        return minPathSum(M-1, N-1, grid, dp);
    }
}