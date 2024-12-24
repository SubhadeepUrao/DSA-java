class Solution {
    int rob(int[] nums, int i, int start) {
        if(i < start) return 0;

        int take = rob(nums, i-2, start) + nums[i];
        int notTake = rob(nums, i-1, start);

        return Math.max(take, notTake);
    }

    public int rob(int[] nums) {
        int N = nums.length;

        if(N == 0) return 0;
        if(N == 1) return nums[0];

        // end is inclusive
        int excludeLast = rob(nums, N-2, 0); // exclude last house
        int excludeFirst = rob(nums, N-1, 1); // exclude first house

        return Math.max(excludeLast, excludeFirst);
    }
}