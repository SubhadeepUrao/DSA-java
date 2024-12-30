class Solution {
    public int numDistinct(String s, String t) {
        int N = s.length();
        int M = t.length();
        int[][] dp = new int[N + 1][M + 1];
        char[] A = s.toCharArray();
        char[] B = t.toCharArray();

        dp[0][0] = 1;

        for (int i = 1; i <= N; ++i) {
            dp[i][0] = 1;
            for (int j = 1; j <= M; ++j) {
                dp[i][j] = A[i - 1] == B[j - 1] ? dp[i - 1][j - 1] + dp[i - 1][j] : dp[i - 1][j];
            }
        }

        return dp[N][M];
    }
}