class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            for (int next = i; next <= N; ++next) {
                if (next == N || nums[i - 1] < nums[next])
                    dp[next] = Math.max(1 + dp[i - 1], dp[next]);
            }
        }

        return dp[N];
    }
}