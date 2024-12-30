class Solution {
    public boolean isMatch(String s, String p) {
        int N = s.length();
        int M = p.length();
        boolean[][] dp = new boolean[N+1][M+1];
        char[] A = s.toCharArray();
        char[] B = p.toCharArray();

        dp[0][0] = true;
        for(int j = 1; j <= M; ++j)
            if(B[j-1] == '*')
                dp[0][j] = dp[0][j-1];

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= M; ++j) {
                dp[i][j] = A[i-1] == B[j-1] || B[j-1] == '?' ? dp[i - 1][j - 1]
                        : B[j-1] == '*' ? dp[i - 1][j] || dp[i][j - 1] : false;
            }
        }

        return dp[N][M];
    }
}