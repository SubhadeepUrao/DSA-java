class Solution {
    int perfectSum(int[] nums, int i, int target) {
        if(target < 0) return 0;
        if(i == 0) {
            if(target == 0 && nums[0] == 0) return 2;
            if(target == 0 || nums[0] == target) return 1;
            return 0;
        }

        return perfectSum(nums, i-1, target-nums[i]) + perfectSum(nums, i-1, target);
    }

    public int perfectSum(int[] nums, int target) {
        int N = nums.length;

        return perfectSum(nums, N-1, target);
    }
}