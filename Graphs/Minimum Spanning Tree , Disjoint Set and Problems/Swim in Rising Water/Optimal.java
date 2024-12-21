class Solution {
    int N;
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    boolean valid(int[][] grid, int time) {
        boolean[][] visited = new boolean[N][N];
        return dfs(grid, visited, time, 0, 0);
    }

    boolean dfs(int[][] grid, boolean[][] visited, int time, int i, int j) {
        if (i < 0 || j < 0 || i == N || j == N || visited[i][j] || grid[i][j] > time)
            return false;
        if (i == N - 1 && i == j)
            return true;

        visited[i][j] = true;

        for (int k = 0; k < 4; ++k) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (dfs(grid, visited, time, x, y))
                return true;
        }
        return false;
    }

    public int swimInWater(int[][] grid) {
        N = grid.length;
        int lb = grid[0][0];
        int ub = N * N - 1;
        int best = 0;

        while (lb <= ub) {
            int mid = (lb + ub) >> 1;
            if (valid(grid, mid)) {
                best = mid;
                ub = mid - 1;
            } else
                lb = mid + 1;
        }
        return best;
    }
}