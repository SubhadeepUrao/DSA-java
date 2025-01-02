class Memoization {
    int solve(int[] nums, int i, int next, Integer[][] dp) {
        if(i < 0) return 0;

        if(dp[i][next] != null) return dp[i][next];

        if(next == nums.length || nums[i] < nums[next])
            return dp[i][next] = Math.max(1 + solve(nums, i-1, i, dp), solve(nums, i-1, next, dp));
        return dp[i][next] = solve(nums, i-1, next, dp);
    }

    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        Integer[][] dp = new Integer[N][N+1];
        return solve(nums, N-1, N, dp);
    }
}