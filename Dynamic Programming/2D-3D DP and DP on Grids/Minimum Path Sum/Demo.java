class Solution {
    int minPathSum(int i, int j, int[][] grid) {
        if(i < 0 || j < 0) return Integer.MAX_VALUE;

        int right = minPathSum(i, j-1, grid);
        int down = minPathSum(i-1, j, grid);

        return Math.min(right, down) + grid[i][j];
    }
    public int minPathSum(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        return minPathSum(M-1, N-1, grid);
    }
}