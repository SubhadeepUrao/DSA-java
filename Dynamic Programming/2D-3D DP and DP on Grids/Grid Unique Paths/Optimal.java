class Solution {
    public int uniquePaths(int M, int N) {
        int[] dp = new int[N];

        for(int i = 0; i < N; ++i)
            dp[i] = 1;

        for(int i = M-2; i >= 0; --i) {
            for(int j = N-2; j >= 0; --j) {
                dp[j] += dp[j+1];
            }
        }
        return dp[0];
    }
}