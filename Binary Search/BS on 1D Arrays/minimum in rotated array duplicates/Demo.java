class Solution {
    public int findMin(int[] nums) {
        int lb = 0;
        int ub = nums.length - 1;

        while (lb < ub) {
            int mid = (lb + ub) >> 1;
            if (nums[lb] < nums[ub]) return nums[lb];
            else if (nums[mid] > nums[ub]) lb = mid + 1;
            else if (nums[mid] < nums[ub]) ub = mid;
            else {
                ++lb;
                --ub;
            }
        }
        return nums[lb];
    }
}