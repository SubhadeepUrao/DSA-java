class Solution {
  public static int maxProduct(int[] nums) {
    int maxi = nums[0];
    int mini = maxi;
    int res = maxi;
    int n = nums.length;

    // maxi: Tracks the maximum product ending at the current position.
    // mini: Tracks the minimum product ending at the current position (important
    // because a large negative can become a large positive if multiplied by another
    // negative).
    // res: Tracks the overall maximum product found so far.
    // occurence of 0 is also handled

    for (int i = 1; i < n; ++i) {
      int temp = Math.max(nums[i], Math.max(maxi * nums[i], mini * nums[i]));
      mini = Math.min(nums[i], Math.min(maxi * nums[i], mini * nums[i]));
      maxi = temp;
      res = Math.max(res, maxi);
    }
    return res;
  }

}
