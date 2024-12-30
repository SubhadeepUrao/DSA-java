class Solution {
    boolean isMatch(char[] A, char[] B, int i, int j, Boolean[][] dp) {
        if (i < 0) {
            if (j < 0) return true;
            while (j >= 0) {
                if (B[j--] != '*') return false;
            }
            return true;
        }
        if (j < 0) return false;

        if (dp[i][j] != null) return dp[i][j];

        if (A[i] == B[j] || B[j] == '?')
            return dp[i][j] = isMatch(A, B, i - 1, j - 1, dp);
        else if (B[j] == '*')
            return dp[i][j] = isMatch(A, B, i - 1, j, dp) || isMatch(A, B, i, j - 1, dp);
        return dp[i][j] = false;
    }

    public boolean isMatch(String s, String p) {
        int N = s.length();
        int M = p.length();
        Boolean[][] dp = new Boolean[N][M];
        return isMatch(s.toCharArray(), p.toCharArray(), N - 1, M - 1, dp);
    }
}