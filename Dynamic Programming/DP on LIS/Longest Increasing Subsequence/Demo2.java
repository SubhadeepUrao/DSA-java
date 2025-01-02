class Solution {
    int lengthOfLIS(int[] nums, int i, int prev) {
        if (i == nums.length) return 0;

        if (prev == -1 || nums[prev] < nums[i])
            return Math.max(1 + lengthOfLIS(nums, i + 1, i), lengthOfLIS(nums, i + 1, prev));
        return lengthOfLIS(nums, i + 1, prev);
    }

    public int lengthOfLIS(int[] nums) {
        return lengthOfLIS(nums, 0, -1);
    }
}