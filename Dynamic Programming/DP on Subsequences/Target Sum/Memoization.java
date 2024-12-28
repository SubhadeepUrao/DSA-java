class Solution {
    int findTargetSumWays(int[] nums, int i, int target, Integer[][] dp, int min) {
        if (i < 0 && target == 0) return 1;
        if (i < 0) return 0;

        if (dp[i][target + min] != null) return dp[i][target + min];

        return dp[i][target + min] = findTargetSumWays(nums, i - 1, target + nums[i], dp, min)
                + findTargetSumWays(nums, i - 1, target - nums[i], dp, min);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int N = nums.length;
        int max = 0;
        for (int num : nums)
            max += num;
        
        max = Math.max(max, Math.abs(target));

        Integer[][] dp = new Integer[N][max * 4 + 1];
        return findTargetSumWays(nums, N - 1, target, dp, max << 1);
    }
}