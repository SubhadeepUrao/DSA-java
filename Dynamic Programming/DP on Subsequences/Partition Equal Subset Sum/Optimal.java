class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;

        for(int num : nums)
            target += num;
        
        if((target & 1) == 1) return false;

        target >>= 1;
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for(int num : nums) {
            for(int i = target; i >= num; --i) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }
}