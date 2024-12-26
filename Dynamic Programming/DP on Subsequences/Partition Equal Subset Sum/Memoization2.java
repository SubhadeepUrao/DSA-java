class Solution {
    boolean canPartition(int[] nums, int i, int target, Boolean[][] dp) {
        if(target == 0) return true;
        if(i < 0 || target < 0) return false;

        if(dp[i][target] != null) return dp[i][target];

        return dp[i][target] = canPartition(nums, i-1, target-nums[i], dp) || canPartition(nums, i-1, target, dp);
    }
    public boolean canPartition(int[] nums) {
        int N = nums.length;
        int target = 0;

        for(int num : nums)
            target += num;

        if((target & 1) == 1) return false;

        target >>= 1;
        Boolean[][] dp = new Boolean[N][target+1];
        return canPartition(nums, N-1, target, dp);
    }
}
