import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Solution {
    public int[][] longestCommonSubsequence(String text1, String text2) {
        int N = text1.length();
        int M = text2.length();

        int[][] dp = new int[N + 1][M + 1];
        char[] A = text1.toCharArray();
        char[] B = text2.toCharArray();

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= M; ++j) {
                dp[i][j] = A[i - 1] == B[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp;
    }
    void genListLCS(char[] A, char[] B, int[][] dp, int i, int j, TreeSet<String> list, String lcs) {
        if (i == 0 || j == 0) {
            list.add(lcs);
            return;
        }
        if (A[i - 1] == B[j - 1]) genListLCS(A, B, dp, i - 1, j - 1, list, A[i - 1] + lcs);
        else {
            if (dp[i][j - 1] == dp[i][j]) genListLCS(A, B, dp, i, j - 1, list, lcs);
            if (dp[i - 1][j] == dp[i][j]) genListLCS(A, B, dp, i - 1, j, list, lcs);
        }
    }
    public List<String> all_longest_common_subsequences(String s, String t) {
        int[][] dp = longestCommonSubsequence(s, t);
        int N = s.length();
        int M = t.length();

        TreeSet<String> list = new TreeSet<>();
        genListLCS(s.toCharArray(), t.toCharArray(), dp, N, M, list, "");
        return new ArrayList<>(list);
    }
}