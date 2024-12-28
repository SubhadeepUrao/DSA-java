class Solution {
    int countPartitions(int[] nums, int d) {
        int N = nums.length;
        int total = 0;
        for (int num : nums)
            total += num;

        if ((total + d) % 2 != 0)
            return 0;

        int target = (total + d) >> 1;
        int[][] dp = new int[N + 1][target + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= target; ++j) {
                dp[i][j] = j >= nums[i - 1] ? dp[i - 1][j - nums[i - 1]] + dp[i - 1][j] : dp[i - 1][j];
            }
        }

        return dp[N][target];
    }
}