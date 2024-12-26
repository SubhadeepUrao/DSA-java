class Solution {
    boolean canPartition(int[] nums, int i, int A, int B) {
        if(i == 0) return A + nums[i] == B || A == B + nums[i];

        boolean same = canPartition(nums, i - 1, A + nums[i], B);
        boolean diff = canPartition(nums, i - 1, A, B + nums[i]);

        return same || diff;
    }
    public boolean canPartition(int[] nums) {
        int N = nums.length;
        return canPartition(nums, N-1, 0, 0);
    }
}