class Solution {
    int absoluteDiff(int a, int b) {
        return a > b ? a - b : b - a;
    }

    int minimumDifference(int[] nums, int i, int sum, int total, int n, int N) {

        if (n == N)
            return absoluteDiff(sum, total - sum);
        if (i == 0)
            return Integer.MAX_VALUE;

        return Math.min(minimumDifference(nums, i - 1, sum + nums[i], total, n + 1, N),
                minimumDifference(nums, i - 1, sum, total, n, N));
    }

    public int minimumDifference(int[] nums) {
        int N = nums.length;
        int target = 0;
        for (int num : nums)
            target += num;

        return minimumDifference(nums, N - 1, 0, target, 0, N >> 1);
    }
}