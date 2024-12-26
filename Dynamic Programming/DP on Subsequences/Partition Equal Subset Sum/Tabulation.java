class Solution {
    public boolean canPartition(int[] nums) {
        int N = nums.length;
        int target = 0;

        for(int num : nums)
            target += num;
        
        if((target & 1) == 1) return false;

        target >>= 1;
        boolean[][] dp = new boolean[N][target+1];

        for(int i = 0; i < N; ++i)
            dp[i][0] = true;
        
        if(target >= nums[0])
            dp[0][nums[0]] = true;

        for(int i = 1; i < N; ++i) {
            for(int j = 1; j <= target; ++j) {
                boolean take = j >= nums[i] ? dp[i-1][j-nums[i]] : false;
                boolean notTake = dp[i-1][j];
                dp[i][j] = take || notTake;
            }
        }
        return dp[N-1][target];
    }
}