class RangeOfX {
  int lowerBound(int[] nums, int x) {
    int lb = 0, ub = nums.length - 1;
    while (lb <= ub) {
      int mid = (lb + ub) >> 1;
      if (x <= nums[mid])
        ub = mid - 1;
      else
        lb = mid + 1;
    }
    return lb;
  }

  int[] searchRange(int[] nums, int target) {
    int n = nums.length;

    if (n == 0)
      return new int[] { -1, -1 };

    int first = lowerBound(nums, target);

    if (first == n || nums[first] != target)
      return new int[] { -1, -1 };

    int last = lowerBound(nums, target + 1) - 1;

    return new int[] { first, last };
  }
}
