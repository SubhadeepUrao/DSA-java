class Solution {
    int findTargetSumWays(int[] nums, int d) {
        int total = 0;
        for (int num : nums)
            total += num;

        if (d > total || d + total < 0 || (d + total) % 2 != 0) {
            return 0;
        }

        int target = (total - d) >> 1; // either total-d or total+d
        int[] prev = new int[target + 1];

        prev[0] = 1;

        for (int num : nums) {
            for (int j = target; j >= num; --j) {
                prev[j] = prev[j - num] + prev[j];
            }
        }

        return prev[target];
    }
}