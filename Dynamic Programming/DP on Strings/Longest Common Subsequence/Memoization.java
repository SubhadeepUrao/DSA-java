class Solution {
    int longestCommonSubsequence(char[] A, char[] B, int i, int j, Integer[][] dp) {
        if (i < 0 || j < 0) return 0;

        if(dp[i][j] != null) return dp[i][j];

        if (A[i] == B[j])
            return dp[i][j] = longestCommonSubsequence(A, B, i - 1, j - 1, dp) + 1;
        return dp[i][j] = Math.max(longestCommonSubsequence(A, B, i - 1, j, dp), longestCommonSubsequence(A, B, i, j - 1, dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int N = text1.length();
        int M = text2.length();

        Integer[][] dp = new Integer[N][M];

        return longestCommonSubsequence(text1.toCharArray(), text2.toCharArray(), N - 1, M - 1, dp);
    }
}