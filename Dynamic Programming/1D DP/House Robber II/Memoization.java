import java.util.Arrays;

class Solution {
    int rob(int[] nums, int i, int end, int[] dp) {
        if(i < end) return 0;

        if(dp[i] != -1) return dp[i];

        int take = rob(nums, i-2, end, dp) + nums[i];
        int notTake = rob(nums, i-1, end, dp);

        return dp[i] = Math.max(take, notTake);
    }

    public int rob(int[] nums) {
        int N = nums.length;

        if(N == 0) return 0;
        if(N == 1) return nums[0];

        int[] dp = new int[N];
        
        // end is inclusive
        Arrays.fill(dp, -1);
        int excludeLast = rob(nums, N-2, 0, dp); // exclude last house

        Arrays.fill(dp, -1);
        int excludeFirst = rob(nums, N-1, 1, dp); // exclude first house

        return Math.max(excludeLast, excludeFirst);
    }
}