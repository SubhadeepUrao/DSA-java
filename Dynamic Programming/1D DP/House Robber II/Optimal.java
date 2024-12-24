class Solution {
    int rob(int[] nums, int start, int end) {
        int prev = 0;
        int prev2 = 0;

        for(int i = start; i <= end; ++i) {
            int curr = Math.max(prev2 + nums[i], prev);
            prev2 = prev;
            prev = curr;
        }
        return prev;
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