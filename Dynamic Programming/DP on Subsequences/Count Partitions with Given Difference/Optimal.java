class Solution {
    int countPartitions(int[] nums, int d) {
        int N = nums.length;
        int total = 0;
        for (int num : nums)
            total += num;

        if ((total + d) % 2 != 0)
            return 0;

        int target = (total + d) >> 1;
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