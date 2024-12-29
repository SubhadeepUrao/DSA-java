class Solution {
    public int longestPalindromeSubseq(String s) {
        int N = s.length();
        int[][] dp = new int[N][N];
        char[] str = s.toCharArray();

        for (int i = 0; i < N; ++i)
            dp[i][i] = 1;

        for (int j = 1; j < N; ++j) {
            for (int i = j - 1; i >= 0; --i) {
                dp[i][j] = str[i] == str[j] ? 2 + dp[i + 1][j - 1] : Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        }
        return dp[0][N - 1];
    }
}