class Solution {
    int rob(int[] nums, int start, int end) {
        int[] dp = new int[end+1];
        
        for(int i = start; i <= end; ++i) {
            int take = i - start > 1 ? dp[i-2] + nums[i] : nums[i];
            int notTake = i - start > 0 ? dp[i-1] : 0;

            dp[i] = Math.max(take, notTake);
        }
        return dp[end];
    }

    public int rob(int[] nums) {
        int N = nums.length;

        if(N == 0) return 0;
        if(N == 1) return nums[0];

        // end is inclusive
        int excludeLast = rob(nums, 0, N-2); // exclude last house
        int excludeFirst = rob(nums, 1, N-1); // exclude first house

        return Math.max(excludeLast, excludeFirst);
    }
}