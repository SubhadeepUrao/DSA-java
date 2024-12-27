class Solution {
    public int perfectSum(int[] nums, int target) {
        int N = nums.length;
        int[][] dp = new int[N + 1][target + 1];

        for (int i = 0; i <= N; ++i)
            dp[i][0] = 1;

        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= target; ++j) {
                dp[i][j] = j >= nums[i - 1] ? dp[i - 1][j - nums[i - 1]] + dp[i - 1][j] : dp[i - 1][j];
            }
        }

        return dp[N][target];
    }
}