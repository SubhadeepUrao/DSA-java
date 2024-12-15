class Solution {
    int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || visited[i][j] || grid[i][j] == 1)
            return Integer.MAX_VALUE;
        if(i+1 == grid.length && j+1 == grid[0].length) return 1;

        visited[i][j] = true;

        int mini = Integer.MAX_VALUE;
        for(int x = -1; x <= 1; ++x) {
            for(int y = -1; y <= 1; ++y) {
                if(i+x != i || j+y != j) {
                    mini = Math.min(mini, dfs(grid, visited, i+x, j+y));
                }
            }
        }
        return mini != Integer.MAX_VALUE ? mini + 1 : mini;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return dfs(grid, visited, 0, 0);
    }
}