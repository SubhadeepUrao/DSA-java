class Solution {
    int countPartitions(int[] nums, int d, int i, int sum, int total) {
        if(Math.abs(total - (sum << 1)) == d) return 1;
        if(i < 0) return 0;

        return countPartitions(nums, d, i-1, sum+nums[i], total) + countPartitions(nums, d, i-1, sum, total);
    }
    int countPartitions(int[] nums, int d) {
        int N = nums.length;
        int total = 0;
        for(int num : nums)
            total += num;
        
        return countPartitions(nums, d, N-1, 0, total);
    }
}
