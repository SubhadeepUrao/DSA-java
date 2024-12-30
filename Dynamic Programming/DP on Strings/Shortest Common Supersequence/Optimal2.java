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
        StringBuilder seq = new StringBuilder();

        while (i > 0 && j > 0) {
            if (A[i - 1] == B[j - 1]) {
                seq.append(A[i - 1]);
                --i;
                --j;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                seq.append(B[j - 1]);
                --j;
            } else {
                seq.append(A[i - 1]);
                --i;
            }
        }
        
        // Append remaining characters from either string
        while (i > 0) {
            seq.append(A[i - 1]);
            --i;
        }
        while (j > 0) {
            seq.append(B[j - 1]);
            --j;
        }
        return seq.reverse().toString();
    }
}