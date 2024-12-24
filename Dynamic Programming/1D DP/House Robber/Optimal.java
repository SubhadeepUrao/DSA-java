class Solution {
    public int rob(int[] nums) {
        int N = nums.length;

        int prev = nums[0];
        int prev2 = 0;

        for(int i = 1; i < N; ++i) {
            int take = i > 1 ? prev2 + nums[i] : nums[i];
            int notTake = prev;

            prev2 = prev;
            prev = Math.max(take, notTake);
        }
        return prev;
    }

    // public int rob(int[] nums) {
    //     int N = nums.length;

    //     int prev = 0;
    //     int prev2 = 0;

    //     for(int i = 0; i < N; ++i) {
    //         int take = i > 1 ? prev2 + nums[i] : nums[i];
    //         int notTake = i > 0 ? prev : nums[0];

    //         prev2 = prev;
    //         prev = Math.max(take, notTake);
    //     }
    //     return prev;
    // }
}