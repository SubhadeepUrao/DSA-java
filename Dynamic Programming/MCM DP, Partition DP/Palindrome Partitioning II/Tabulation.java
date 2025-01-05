// TLE
class Solution {
    boolean isPalindrome(char[] str, int i, int j) {
        while (i < j) {
            if(str[i] != str[j]) return false;
            ++i;
            --j;
        }
        return true;
    }

    public int minCut(String s) {
        int N = s.length();
        char[] str = s.toCharArray();
        int[][] dp = new int[N][N];

        for (int i = N - 1; i >= 0; --i) {
            for (int j = i + 1; j < N; ++j) {
                int mini = Integer.MAX_VALUE;
                for (int k = i; k < j; ++k) {
                    if (isPalindrome(str, i, k))
                        mini = Math.min(mini, dp[k + 1][j]);
                }
                dp[i][j] = mini + 1;
            }
        }
        return dp[0][N - 1];
    }
}