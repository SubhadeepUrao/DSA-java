class Solution {
    int absoluteDiff(int a, int b) {
        return a > b ? a - b : b - a;
    }

    int minimumDifference(int[] nums, int i, int sum, int total) {
        if (i == 0)
            return sum != total ? absoluteDiff(sum, total - sum) : Integer.MAX_VALUE;

        return Math.min(minimumDifference(nums, i-1, sum+nums[i], total), minimumDifference(nums, i-1, sum, total));
    }

    public int minimumDifference(int[] nums) {
        int N = nums.length;
        int target = 0;
        for(int num : nums)
        target += num;

        return minimumDifference(nums, N - 1, 0, target);
    }
}