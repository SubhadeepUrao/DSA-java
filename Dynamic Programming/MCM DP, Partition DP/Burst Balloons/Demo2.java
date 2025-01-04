class Solution {
    int maxCoins(int[] nums, int i, int j) {
        if (i > j) return 0;

        // traversing backwards from the last element to be eliminated
        int maxi = Integer.MIN_VALUE;
        for (int k = i; k <= j; ++k) {
            maxi = Math.max(maxi,
                    maxCoins(nums, i, k - 1) + maxCoins(nums, k + 1, j) + nums[i - 1] * nums[k] * nums[j + 1]);
        }
        return maxi;
    }

    public int maxCoins(int[] nums) {
        int N = nums.length;
        int[] newNums = new int[N + 2];
        newNums[0] = newNums[N + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, N);

        return maxCoins(newNums, 1, N);
    }
}