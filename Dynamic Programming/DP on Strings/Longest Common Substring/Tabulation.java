class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        int N = s1.length();
        int M = s2.length();
        int[][] dp = new int[N + 1][M + 1];
        char[] A = s1.toCharArray();
        char[] B = s2.toCharArray();

        int maxLength = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = A[i - 1] == B[j - 1] ? 1 + dp[i - 1][j - 1] : 0;
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }
}