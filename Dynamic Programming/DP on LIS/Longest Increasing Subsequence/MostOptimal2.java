import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        List<Integer> list = new LinkedList<>();
        list.add(nums[0]);

        for (int i = 1; i < N; ++i) {
            int pos = Collections.binarySearch(list, nums[i]);
            if (pos < 0) {
                pos = -pos - 1;
                if (pos == list.size())
                    list.add(nums[i]);
                else
                    list.set(pos, nums[i]);
            }
        }
        return list.size();
    }
}
