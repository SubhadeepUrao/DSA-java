import java.util.List;

class Solution {
    int minimumTotal(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        if (i + 1 == triangle.size())
            return dp[i][j] = triangle.get(i).get(j);
        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];

        return dp[i][j] = Math.min(minimumTotal(triangle, i + 1, j, dp), minimumTotal(triangle, i + 1, j + 1, dp))
                + triangle.get(i).get(j);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int M = triangle.size();
        int N = triangle.get(M-1).size();
        int[][] dp = new int[M][N];

        for (int i = 0; i < M; ++i)
            for (int j = 0; j < N; ++j)
                dp[i][j] = Integer.MAX_VALUE;

        return minimumTotal(triangle, 0, 0, dp);
    }
}