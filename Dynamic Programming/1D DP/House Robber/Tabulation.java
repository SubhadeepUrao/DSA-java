class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        dp[0] = nums[0];

        for(int i = 1; i < N; ++i) {
            int take = i > 1 ? dp[i-2] + nums[i] : nums[i];
            int notTake = dp[i-1];

            dp[i] = Math.max(take, notTake);
        }
        return dp[N-1];
    }
    
    // public int rob(int[] nums) {
    //     int N = nums.length;
    //     int[] dp = new int[N];

    //     for(int i = 0; i < N; ++i) {
    //         int take = i > 1 ? dp[i-2] + nums[i] : nums[i];
    //         int notTake = i > 0 ? dp[i-1] : nums[0];

    //         dp[i] = Math.max(take, notTake);
    //     }
    //     return dp[N-1];
    // }
}