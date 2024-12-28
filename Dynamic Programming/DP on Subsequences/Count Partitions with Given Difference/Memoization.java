class Solution {
    int countPartitions(int[] nums, int i, int target, Integer[][] dp) {
        if (i < 0 && target == 0) return 1;
        if (i < 0) return 0;

        if(dp[i][target] != null) return dp[i][target];

        if (nums[i] <= target)
            return dp[i][target] = countPartitions(nums, i - 1, target - nums[i], dp) + countPartitions(nums, i - 1, target, dp);
        return dp[i][target] = countPartitions(nums, i - 1, target, dp);
    }

    int countPartitions(int[] nums, int d) {
        int N = nums.length;
        int total = 0;
        for (int num : nums)
            total += num;

        if ((total + d) % 2 != 0)
            return 0;

        int target = (total + d) >> 1;
        Integer[][] dp = new Integer[N][target + 1];

        return countPartitions(nums, N - 1, target, dp);
    }
}
