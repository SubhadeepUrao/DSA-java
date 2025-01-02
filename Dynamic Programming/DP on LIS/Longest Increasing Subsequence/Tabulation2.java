class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[][] dp = new int[N + 1][N + 1];

        for (int i = N - 1; i >= 0; --i) {
            for (int prev = i - 1; prev >= -1; --prev) {
                if (prev == -1 || nums[prev] < nums[i])
                    dp[i][prev + 1] = Math.max(1 + dp[i + 1][i + 1], dp[i + 1][prev + 1]);
                else
                    dp[i][prev + 1] = dp[i + 1][prev + 1];
            }
        }
        return dp[0][0];
    }
}