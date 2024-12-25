import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();
        return minimumTotal(0, 0, N, new int[N][N], new boolean[N][N], triangle);
    }

    public int minimumTotal(int i, int j, int N, int[][] dp, boolean[][] visited, List<List<Integer>> triangle) {
        if (i == N)
            return 0;

        if (!visited[i][j]) {
            visited[i][j] = true;
            return dp[i][j] = Math.min(minimumTotal(i + 1, j, N, dp, visited, triangle),
                    minimumTotal(i + 1, j + 1, N, dp, visited, triangle)) + triangle.get(i).get(j);
        }
        return dp[i][j];
    }
}