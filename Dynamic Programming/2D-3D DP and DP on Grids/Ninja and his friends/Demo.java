class Solution {
    int solve(int i, int left, int right, int[][] grid, int N, int M) {
        if(i == N || left < 0 || left == M || right < 0 || right == M) return 0;
        
        int choco = 0;
        for (int p = left - 1; p <= left + 1; ++p) {
            for (int q = right - 1; q <= right + 1; ++q) {
                choco = Math.max(choco, solve(i + 1, p, q, grid, N, M));
            }
        }
        return left == right ? choco + grid[i][left] : choco + grid[i][left] + grid[i][right];
    }
    public int solve(int N, int M, int grid[][]) {
        return solve(0, 0, M-1, grid, N, M);
    }
}