class Solution {
    public int minDistance(String word1, String word2) {
        int N = word1.length();
        int M = word2.length();
        int[][] dp = new int[N + 1][M + 1];
        char[] A = word1.toCharArray();
        char[] B = word2.toCharArray();

        for (int j = 1; j <= M; ++j)
            dp[0][j] = j;

        for (int i = 1; i <= N; ++i) {
            dp[i][0] = i;
            for (int j = 1; j <= M; ++j) {
                dp[i][j] = A[i - 1] == B[j - 1] ? dp[i - 1][j - 1]
                        : 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[N][M];
    }
}