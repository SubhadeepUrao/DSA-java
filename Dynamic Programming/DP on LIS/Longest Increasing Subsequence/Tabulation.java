class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; ++i) {
            for (int next = i; next <= N; ++next) {
                if (next == N || nums[i - 1] < nums[next])
                    dp[i][next] = Math.max(1 + dp[i - 1][i - 1], dp[i - 1][next]);
                else
                    dp[i][next] = dp[i - 1][next];
            }
        }

        return dp[N][N];
    }
}