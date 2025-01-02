class Solution {
    int lengthOfLIS(int[] nums, int i, int next) {
        if (i < 0) return 0;

        if (next == nums.length || nums[i] < nums[next])
            return Math.max(1 + lengthOfLIS(nums, i - 1, i), lengthOfLIS(nums, i - 1, next));
        return lengthOfLIS(nums, i - 1, next);
    }

    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        return lengthOfLIS(nums, N - 1, N);
    }
}