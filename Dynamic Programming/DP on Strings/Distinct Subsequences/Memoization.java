class Solution {
    int numDistinct(char[] A, char[] B, int i, int j, Integer[][] dp) {
        if (j < 0) return 1;
        if (i < 0) return 0;

        if (dp[i][j] != null) return dp[i][j];

        if (A[i] == B[j])
            return dp[i][j] = numDistinct(A, B, i - 1, j - 1, dp) + numDistinct(A, B, i - 1, j, dp);
        return dp[i][j] = numDistinct(A, B, i - 1, j, dp);
    }

    public int numDistinct(String s, String t) {
        int N = s.length();
        int M = t.length();
        Integer[][] dp = new Integer[N][M];

        return numDistinct(s.toCharArray(), t.toCharArray(), N - 1, M - 1, dp);
    }
}