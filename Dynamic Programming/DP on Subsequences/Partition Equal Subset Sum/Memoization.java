class Solution {
    boolean canPartition(int[] nums, int i, int target, int[][] dp) {
        if(target == 0) return true;
        if(i == 0) return nums[i] == target;

        if(dp[i][target] != 0) return dp[i][target] == 1 ? true : false;

        boolean take = target >= nums[i] ? canPartition(nums, i-1, target-nums[i], dp) : false;
        boolean notTake = canPartition(nums, i-1, target, dp);

        dp[i][target] = take || notTake ? 1 : -1;
        return take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int N = nums.length;
        int target = 0;

        // target = Arrays.stream(nums).sum();
        for(int num : nums)
            target += num;
        
        if((target & 1) == 1) return false;

        target >>= 1;
        int[][] dp = new int[N][target+1];
        return canPartition(nums, N-1, target, dp);
    }
}