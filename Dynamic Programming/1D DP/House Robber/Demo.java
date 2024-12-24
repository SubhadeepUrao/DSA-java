class Solution {
    int rob(int[] nums, int i) {
        if(i < 0) return 0;
        
        int take = rob(nums, i-2) + nums[i];
        int notTake = rob(nums, i-1);

        return Math.max(take, notTake);
    }
    public int rob(int[] nums) {
        return rob(nums, nums.length-1);
    }
}