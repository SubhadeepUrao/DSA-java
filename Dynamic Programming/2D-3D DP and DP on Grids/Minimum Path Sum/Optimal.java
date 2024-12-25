class Solution {
    public int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[] prev = new int[N];

        prev[0] = grid[0][0];
        for(int j = 1; j < N; ++j)
            prev[j] = prev[j-1] + grid[0][j];
        
        for(int i = 1; i < M; ++i) {
            prev[0] += grid[i][0];
            for(int j = 1; j < N; ++j) {
                prev[j] = Math.min(prev[j], prev[j-1]) + grid[i][j];
            }
        }

        return prev[N-1];
    }
}