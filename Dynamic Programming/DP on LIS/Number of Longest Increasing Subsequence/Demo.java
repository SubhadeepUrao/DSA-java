class Solution {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        int[] count = new int[N];
        int maxi = 1;
        int cnt = 0;

        dp[0] = 1;
        count[0] = 1;

        for (int i = 1; i < N; ++i) {
            int lmax = 0;
            count[i] = 1;
            for (int prev = 0; prev < i; ++prev) {
                if (nums[prev] < nums[i])
                    if (lmax < dp[prev]) {
                        lmax = dp[prev];
                        count[i] = count[prev];
                    } else if (lmax == dp[prev])
                        count[i] += count[prev];
            }
            dp[i] = lmax + 1;
            maxi = Math.max(maxi, dp[i]);
        }
        for (int i = 0; i < N; ++i)
            if (dp[i] == maxi) cnt += count[i];
        return cnt;
    }
}