class Solution {
    int perfectSum(int[] nums, int i, int target, Integer[][] dp) {
        if(target == 0) {
            int cnt = 1; // At least one subset: the empty subset
            while(i >= 0) {
                if(nums[i] == 0) cnt <<= 1; // Each zero doubles the subset count
                --i;
            }
            return cnt;
        }
        if(i < 0 || target < 0) return 0;

        if(dp[i][target] != null) return dp[i][target];

        return dp[i][target] = perfectSum(nums, i - 1, target - nums[i], dp) + perfectSum(nums, i - 1, target, dp);
    }

    public int perfectSum(int[] nums, int target) {
        int N = nums.length;
        Integer[][] dp = new Integer[N][target + 1];

        return perfectSum(nums, N - 1, target, dp);
    }
}