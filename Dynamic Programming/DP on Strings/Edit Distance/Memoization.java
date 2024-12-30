class Solution {
    int minDistance(char[] A, char[] B, int i, int j, Integer[][] dp) {
        if (i < 0) return j + 1; // all inserts
        if (j < 0) return i + 1; // all removals

        if(dp[i][j] != null) return dp[i][j];

        if (A[i] == B[j])
            return dp[i][j] = minDistance(A, B, i - 1, j - 1, dp);
        return dp[i][j] = 1 + Math.min(minDistance(A, B, i - 1, j - 1, dp),
                Math.min(minDistance(A, B, i - 1, j, dp), minDistance(A, B, i, j - 1, dp)));
    }

    public int minDistance(String word1, String word2) {
        int N = word1.length();
        int M = word2.length();
        Integer[][] dp = new Integer[N][M];
        return minDistance(word1.toCharArray(), word2.toCharArray(), N - 1, M - 1, dp);
    }
}