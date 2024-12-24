import java.util.Arrays;

class Solution {
    int rob(int[] nums, int i, int[] dp) {
        if(i < 0) return 0;

        if(dp[i] != -1) return dp[i];
        
        int take = rob(nums, i-2, dp) + nums[i];
        int notTake = rob(nums, i-1, dp);

        return dp[i] = Math.max(take, notTake);
    }
    public int rob(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        return rob(nums, N-1, dp);
    }
}