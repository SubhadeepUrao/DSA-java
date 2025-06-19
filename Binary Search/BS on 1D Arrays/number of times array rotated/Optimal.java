import java.util.ArrayList;

class Solution {
  public int findKRotation(ArrayList<Integer> nums) {
    int lb = 0;
    int ub = nums.size() - 1;
    int mini = Integer.MAX_VALUE;
    int index = -1;

    while (lb <= ub) {
      int mid = (lb + ub) >> 1;
      int curr = nums.get(mid);
      if (curr < mini) { // find minimum
        mini = curr;
        index = mid;
      }
      if (curr <= nums.get(ub)) ub = mid - 1;
      else lb = mid + 1;
    }
    return index;
  }
}