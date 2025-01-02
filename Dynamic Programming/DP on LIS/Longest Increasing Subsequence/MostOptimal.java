class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];

        int max = 1;
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            int lmax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    lmax = Math.max(dp[j], lmax);
                }
            }
            // when lmax == 0, means nums[j] < nums[i] did not satisfy for once, so we cannot extend the length
            // therefore dp[i] = 1, means another possible LIS begins
            dp[i] = lmax + 1; 
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}