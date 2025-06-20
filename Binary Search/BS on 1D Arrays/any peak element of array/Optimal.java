class Solution {
  public int findPeakElement(int[] nums) {
    int lb = 0;
    int ub = nums.length - 1;
    int n = ub;

    while (lb <= ub) {
      int mid = (lb + ub) >> 1;
      if (mid < n && nums[mid] <= nums[mid + 1])
        lb = mid + 1;
      else
        ub = mid - 1;
    }
    return lb;
  }
}