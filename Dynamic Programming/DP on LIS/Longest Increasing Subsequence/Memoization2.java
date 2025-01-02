class Memoization2 {
    int lengthOfLIS(int[] nums, int i, int prev, Integer[][] dp) {
        if (i == nums.length) return 0;

        if (dp[i][prev + 1] != null) return dp[i][prev + 1];

        if (prev == -1 || nums[prev] < nums[i])
            return dp[i][prev + 1] = Math.max(1 + lengthOfLIS(nums, i + 1, i, dp),
                    lengthOfLIS(nums, i + 1, prev, dp));
        return dp[i][prev + 1] = lengthOfLIS(nums, i + 1, prev, dp);
    }

    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        Integer[][] dp = new Integer[N][N];
        return lengthOfLIS(nums, 0, -1, dp);
    }
}