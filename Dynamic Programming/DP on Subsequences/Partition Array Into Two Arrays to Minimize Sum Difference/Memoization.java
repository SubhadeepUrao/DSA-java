// MEMORY LIMIT EXCEEDED
class Solution {

    int minLimit = 0;
    int maxLimit = 0;

    int absoluteDiff(int a, int b) {
        return Math.abs(a - b);
    }

    int minimumDifference(int[] nums, int i, int sum, int total, int n, int N, Integer[][] dp) {

        if (n == N)
            return absoluteDiff(sum, total - sum);
        if (i == 0)
            return Integer.MAX_VALUE;

        if (dp[i][sum - minLimit] != null)
            return dp[i][minLimit];

        return dp[i][sum - minLimit] = Math.min(minimumDifference(nums, i - 1, sum + nums[i], total, n + 1, N, dp),
                minimumDifference(nums, i - 1, sum, total, n, N, dp));
    }

    public int minimumDifference(int[] nums) {
        int N = nums.length;
        int target = 0;
        for (int num : nums) {
            if (num < 0)
                minLimit += num;
            else
                maxLimit += num;
            target += num;
        }

        Integer[][] dp = new Integer[N][maxLimit - minLimit + 1];

        return minimumDifference(nums, N - 1, 0, target, 0, N >> 1, dp);
    }
}