import java.util.Arrays;

// TIME LIMIT EXCEEDED
class Solution {
    int findContentChildren(int[] greed, int[] size, int i, int j, Integer[][] dp) {
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != null) return dp[i][j];

        if(greed[i] <= size[j]) {
            int includeCookie = findContentChildren(greed, size, i-1, j-1, dp) + 1;
            int excludeCookie = findContentChildren(greed, size, i, j-1, dp);
            return dp[i][j] = Math.max(includeCookie, excludeCookie);
        }
        return dp[i][j] = findContentChildren(greed, size, i-1, j, dp);
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // Sort greed factors
        Arrays.sort(s); // Sort cookie sizes
        int N = g.length;
        int M = s.length;

        Integer[][] dp = new Integer[N][M];

        return findContentChildren(g, s, N-1, M-1, dp);
    }
}
