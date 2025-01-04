class Solution {
    public int maxCoins(int[] nums) {
        int N = nums.length;
        int[] newNums = new int[N + 2];
        newNums[0] = newNums[N + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, N);

        int[][] dp = new int[N + 2][N + 2];

        for(int i = N; i >= 1; --i) {
            for(int j = i; j <= N; ++j) {
                int maxi = Integer.MIN_VALUE;
                for (int k = i; k <= j; ++k) {
                    maxi = Math.max(maxi, dp[i][k - 1] + dp[k + 1][j] + newNums[i - 1] * newNums[k] * newNums[j + 1]);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][N];
    }
}