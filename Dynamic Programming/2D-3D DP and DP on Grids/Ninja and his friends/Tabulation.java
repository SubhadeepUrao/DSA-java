class Solution {
    int helper(int i, int left, int right, int[][][] dp, int N, int M) {
        if(i == N-1) return 0;
        
        int choco = 0;
        for (int p = left - 1; p <= left + 1; ++p) {
            for (int q = right - 1; q <= right + 1; ++q) {
                if(p < 0 || p == M || q < 0 || q == M) continue;
                choco = Math.max(choco, dp[i+1][p][q]);
            }
        }
        return choco;
    }
    public int solve(int N, int M, int grid[][]) {
        int[][][] dp = new int[N][M][M];
        for(int i = N-1; i >= 0; --i)
            for(int left = M-1; left >= 0; --left)
                for(int right = M-1; right >= 0; --right) {
                    int choco = helper(i, left, right, dp, N, M);
                    dp[i][left][right] = choco + (left == right ? grid[i][left] : grid[i][left] + grid[i][right]);
                }
        
        return dp[0][0][M-1];
    }
}