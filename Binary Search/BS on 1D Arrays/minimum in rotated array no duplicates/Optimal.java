class Solution {
  public int findMin(int[] nums) {
    int lb = 0, ub = nums.length - 1;
    int mini = nums[0];

    while (lb <= ub) {
      int mid = (lb + ub) >> 1;
      mini = Math.min(mini, nums[mid]);

      if (nums[mid] <= nums[ub])
        ub = mid - 1;
      else
        lb = mid + 1;
    }
    return mini;
  }
}