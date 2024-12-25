class Solution {
    int solve(int i, int left, int right, int[][] grid, int N, int M, int[][][] dp) {
        if(i == N || left < 0 || left == M || right < 0 || right == M) return 0;

        if(dp[i][left][right] != -1) return dp[i][left][right];

        int choco = 0;
        for (int p = left - 1; p <= left + 1; ++p) {
            for (int q = right - 1; q <= right + 1; ++q) {
                choco = Math.max(choco, solve(i + 1, p, q, grid, N, M, dp));
            }
        }
        return dp[i][left][right] = choco + (left == right ? grid[i][left] : grid[i][left] + grid[i][right]);
    }
    public int solve(int N, int M, int grid[][]) {
        int[][][] dp = new int[N][M][M];
        for(int i = 0; i < N; ++i)
            for(int j = 0; j < M; ++j)
                for(int k = 0; k < M; ++k)
                    dp[i][j][k] = -1;
        
        return solve(0, 0, M-1, grid, N, M, dp);
    }
}