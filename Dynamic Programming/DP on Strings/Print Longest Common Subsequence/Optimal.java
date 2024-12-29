import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public List<String> all_longest_common_subsequences(String s, String t) {
        int N = s.length();
        int M = t.length();
        char[] A = s.toCharArray();
        char[] B = t.toCharArray();

        int[][] dp = new int[N + 1][M + 1];
        // Set<String>[][] LCS = new HashSet[N+1][M+1];
        Set<String>[][] LCS = new TreeSet[N + 1][M + 1];

        for (int i = 0; i <= N; ++i) {
            for (int j = 0; j <= M; ++j) {
                // LCS[i][j] = new HashSet<>();
                LCS[i][j] = new TreeSet<>();
            }
        }

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= M; ++j) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (LCS[i - 1][j - 1].isEmpty())
                        LCS[i][j].add(String.valueOf(A[i - 1]));
                    else
                        for (String lcs : LCS[i - 1][j - 1])
                            LCS[i][j].add(lcs + A[i - 1]);
                } else {
                    if (dp[i][j - 1] > dp[i - 1][j]) {
                        LCS[i][j].addAll(LCS[i][j - 1]);
                        dp[i][j] = dp[i][j - 1];
                    } else if (dp[i][j - 1] < dp[i - 1][j]) {
                        LCS[i][j].addAll(LCS[i - 1][j]);
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        LCS[i][j].addAll(LCS[i][j - 1]);
                        LCS[i][j].addAll(LCS[i - 1][j]);
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }

        // List<String> res = new ArrayList<>(LCS[N][M]);
        // Collections.sort(res);
        // return res;

        return new ArrayList<>(LCS[N][M]);
    }
}