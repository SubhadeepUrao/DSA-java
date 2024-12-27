import java.util.ArrayList;
import java.util.List;

// TIME LIMIT EXCEEDED
class Solution {
    int absoluteDiff(int a, int b) {
        return Math.abs(a - b);
    }

    int findDiff(List<Integer> A, List<Integer> B, int total) {
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); ++i) {
            int a = A.get(i);
            for (int j = 0; j < B.size(); ++j) {
                int b = B.get(j);
                int sum = a + b;
                mini = Math.min(mini, absoluteDiff(sum, total - sum));
            }
        }
        return mini;
    }

    public int minimumDifference(int[] nums) {
        int N = nums.length;
        int total = 0;
        for (int num : nums)
            total += num;

        int n = N >> 1;
        List<Integer>[] left = new ArrayList[n];
        List<Integer>[] right = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        for (int mask = 0; mask < (1 << n); ++mask) {
            int size = 0, l = 0, r = 0;
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0) {
                    ++size;
                    l += nums[i];
                    r += nums[i + n];
                }
            }
            left[size].add(l);
            right[size].add(r);
        }

        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            diff = Math.min(diff, findDiff(left[i], right[n - i], total));
        }
        return diff;
    }
}