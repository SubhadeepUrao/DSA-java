import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    int n = nums.length;
    List<Integer> list = new ArrayList<>();

    int i = 0;
    while (i < n) {
      int correct = nums[i] - 1; // correct position
      if (nums[i] != nums[correct]) {
        int temp = nums[i];
        nums[i] = nums[correct];
        nums[correct] = temp;
      } else
        ++i;
    }

    for (int j = 0; j < n; ++j) {
      if (nums[j] != j + 1)
        list.add(nums[j]);
    }

    return list;
  }
}