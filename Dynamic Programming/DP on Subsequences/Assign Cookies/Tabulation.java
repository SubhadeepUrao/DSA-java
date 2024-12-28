import java.util.Arrays;

// MEMORY LIMIT EXCEEDED
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // Sort greed factors
        Arrays.sort(s); // Sort cookie sizes
        int N = g.length;
        int M = s.length;

        int[][] dp = new int[N+1][M+1];

        for(int i = 1; i <= N; ++i) {
            for(int j = 1; j <= M; ++j) {
                if(g[i-1] <= s[j-1])
                    dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i][j-1]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[N][M];
    }
}