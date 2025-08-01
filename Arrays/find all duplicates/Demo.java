import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    int n = nums.length;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      int elem = Math.abs(nums[i]);
      if (nums[elem - 1] < 0)
        list.add(elem);
      else
        nums[elem - 1] = -nums[elem - 1];
    }
    return list;
  }
}