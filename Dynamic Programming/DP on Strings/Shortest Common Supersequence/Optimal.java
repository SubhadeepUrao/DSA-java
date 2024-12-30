class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int N = str1.length();
        int M = str2.length();

        int[][] dp = new int[N + 1][M + 1];
        char[] A = str1.toCharArray();
        char[] B = str2.toCharArray();

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= M; ++j) {
                dp[i][j] = A[i - 1] == B[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int i = N;
        int j = M;
        String seq = "";
        while (i > 0 && j > 0) {
            if (A[i - 1] == B[j - 1]) {
                seq = A[i - 1] + seq;
                --i;
                --j;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                seq = B[j - 1] + seq;
                --j;
            } else {
                seq = A[i - 1] + seq;
                --i;
            }
        }
        return str1.substring(0, i) + str2.substring(0, j) + seq;
    }
}