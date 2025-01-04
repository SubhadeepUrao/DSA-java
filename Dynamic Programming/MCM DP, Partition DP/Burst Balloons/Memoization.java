class Solution {
    int maxCoins(int[] nums, int i, int j, Integer[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != null) return dp[i][j];

        // traversing backwards from the last element to be eliminated
        int maxi = Integer.MIN_VALUE;
        for (int k = i; k <= j; ++k) {
            maxi = Math.max(maxi,
                    maxCoins(nums, i, k - 1, dp) + maxCoins(nums, k + 1, j, dp) + nums[i - 1] * nums[k] * nums[j + 1]);
        }
        return dp[i][j] = maxi;
    }

    public int maxCoins(int[] nums) {
        int N = nums.length;
        int[] newNums = new int[N + 2];
        newNums[0] = newNums[N + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, N);

        Integer[][] dp = new Integer[N + 1][N + 1];
        return maxCoins(newNums, 1, N, dp);
    }
}