import java.util.Arrays;

class Solution {
    int dfs(int i, int j, int m, int n, int[][] dp) {
        if(i == m || j == n) return 0;
        if(i == m-1 && j == n-1) return dp[i][j] = 1;

        if(dp[i][j] != -1) return dp[i][j];

        int right = dfs(i, j+1, m, n, dp);
        int down = dfs(i+1, j, m, n, dp);

        return dp[i][j] = right + down; // #paths from (i,j) -> (m-1,n-1)
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; ++i)
            Arrays.fill(dp[i], -1);
        return dfs(0, 0, m, n, dp);
    }
}