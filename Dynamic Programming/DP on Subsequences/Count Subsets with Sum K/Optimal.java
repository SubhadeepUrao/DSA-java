class Solution {
    public int perfectSum(int[] nums, int target) {
        int N = nums.length;
        int[] prev = new int[target + 1];

        prev[0] = 1;
        int[] curr = new int[target + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= target; ++j) {
                curr[j] = j >= nums[i - 1] ? prev[j - nums[i - 1]] + prev[j] : prev[j];
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[target];
    }
}