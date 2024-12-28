class Solution {
    int findTargetSumWays(int[] nums, int i, int target) {
        if(i < 0 && target == 0) return 1;
        if(i < 0) return 0;

        return findTargetSumWays(nums, i - 1, target + nums[i]) + findTargetSumWays(nums, i - 1, target - nums[i]);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int N = nums.length;
        return findTargetSumWays(nums, N - 1, target);
    }
}