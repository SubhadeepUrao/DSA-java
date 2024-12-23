class Solution {
    static long func(long[] memo, int i) {
        if (i <= 1) return i;

        if (memo[i] != 0) return memo[i];

        memo[i] = (func(memo, i - 1) + func(memo, i - 2)) % 1000_000_007;
        return memo[i];
    }

    static long topDown(int n) {
        long[] memo = new long[n + 1];
        return func(memo, n);
    }

    static long bottomUp(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000_000_007;
        }
        return dp[n];
    }
}