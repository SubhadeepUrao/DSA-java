class Solution {
    void infect(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0) return;

        // infect grid[i][j] = 1 with 0
        grid[i][j] = 0;

        infect(grid, i, j-1); // left
        infect(grid, i-1, j); // up
        infect(grid, i, j+1); // right
        infect(grid, i+1, j); // down
    }
    public int numEnclaves(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int lastCol = N-1;
        int lastRow = M-1;

        for(int i = 0; i < N; ++i) {
            if(grid[0][i] == 1) infect(grid, 0, i);
            if(grid[lastRow][i] == 1) infect(grid, lastRow, i);
        }
        for(int i = 1; i < lastRow; ++i) {
            if(grid[i][0] == 1) infect(grid, i, 0);
            if(grid[i][lastCol] == 1) infect(grid, i, lastCol);
        }
        int cnt = 0;
        for(int i = 0; i < M; ++i)
            for(int j = 0; j < N; ++j)
                cnt += grid[i][j];
        return cnt;
    }
}