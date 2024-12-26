class Solution {
    
    int minLimit = 0;
    int maxLimit = 0;

    int absoluteDiff(int a, int b) {
        return a > b ? a - b : b - a;
    }

    int minimumDifference(int[] nums, int i, int sum, int total, Integer[][] dp) {
        if (i == 0)
            return dp[0][sum-minLimit] = sum != total ? absoluteDiff(sum, total - sum) : Integer.MAX_VALUE;

        if (dp[i][sum - minLimit] != null)
            return dp[i][sum - minLimit];

        return dp[i][sum - minLimit] = Math.min(minimumDifference(nums, i - 1, sum + nums[i], total, dp),
                minimumDifference(nums, i - 1, sum, total, dp));
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

        return minimumDifference(nums, N - 1, 0, target, dp);
    }
}