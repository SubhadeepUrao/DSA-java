class Solution {
    public static int longestCommonSubstr(char[] A, char[] B, int i, int j, Integer[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != null) return dp[i][j];

        if (A[i] == B[j])
            return dp[i][j] = 1 + longestCommonSubstr(A, B, i - 1, j - 1, dp);
        return dp[i][j] = 0;
    }

    public int longestCommonSubstr(String s1, String s2) {
        int N = s1.length();
        int M = s2.length();
        Integer[][] dp = new Integer[N][M];
        char[] A = s1.toCharArray();
        char[] B = s2.toCharArray();

        int maxLength = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                maxLength = Math.max(maxLength, longestCommonSubstr(A, B, i, j, dp));
            }
        }
        return maxLength;
    }
}