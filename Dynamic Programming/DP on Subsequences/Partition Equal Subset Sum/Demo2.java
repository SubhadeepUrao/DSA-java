import java.util.Arrays;

class Solution {
    boolean canPartition(int[] nums, int i, int target) {
        if(target == 0) return true;
        if(i == 0) return nums[i] == target;

        boolean take = target >= nums[i] ? canPartition(nums, i-1, target-nums[i]) : false;
        boolean notTake = canPartition(nums, i-1, target);

        return take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int N = nums.length;
        int target = Arrays.stream(nums).sum();
        if((target & 1) == 1) return false;
        return canPartition(nums, N-1, target >> 1);
    }
}