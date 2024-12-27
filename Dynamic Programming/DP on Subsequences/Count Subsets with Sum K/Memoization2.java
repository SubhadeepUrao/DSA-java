class Solution {
    int perfectSum(int[] nums, int i, int target) {
        if(i < 0 && target == 0) return 1;
        if(i < 0) return 0;

        if(target >= nums[i])
            return perfectSum(nums, i-1, target-nums[i]) + perfectSum(nums, i-1, target);
        return perfectSum(nums, i-1, target); // skip it
    }
    public int perfectSum(int[] nums, int target) {
        int N = nums.length;
        return perfectSum(nums, N-1, target);
    }
}