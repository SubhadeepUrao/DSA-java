// same as Count Partitions with given difference
class Solution {
    int findTargetSumWays(int[] nums, int i, int target, Integer[][] dp) {
        if(i < 0 && target == 0) return 1;
        if(i < 0) return 0;

        if(dp[i][target] != null) return dp[i][target];

        if(target >= nums[i])
            return dp[i][target] = findTargetSumWays(nums, i-1, target-nums[i], dp) + findTargetSumWays(nums, i-1, target, dp);
        return dp[i][target] = findTargetSumWays(nums, i-1, target, dp);
    }
    public int findTargetSumWays(int[] nums, int d) {
        int N = nums.length;
        int total = 0;
        for (int num : nums)
            total += num;
        
        if (d > total || d + total < 0 || (d + total) % 2 != 0) {
            return 0;
        }

        int target = (total - d) >> 1;
        Integer[][] dp = new Integer[N][target + 1];

        return findTargetSumWays(nums, N-1, target, dp);
    }
}