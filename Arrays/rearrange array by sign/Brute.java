class Solution {
  void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public int[] rearrangeArray(int[] nums) {
    int curr = 0;
    int n = nums.length - 1;

    while (curr < n) {
      int next = curr + 1;
      if ((curr & 1) == 0) { // positive position
        while (nums[curr] < 0)
          swap(nums, curr, next++);
      } else { // negative position
        while (nums[curr] > 0)
          swap(nums, curr, next++);
      }
      ++curr;
    }
    return nums;
  }
}

/**
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */