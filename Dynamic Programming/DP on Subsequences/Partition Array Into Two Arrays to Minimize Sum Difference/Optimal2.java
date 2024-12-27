import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    int absoluteDiff(int a, int b) {
        return Math.abs(a - b);
    }

    public int minimumDifference(int[] nums) {
        int N = nums.length;
        int total = 0;
        for (int num : nums)
            total += num;

        int n = N >> 1;
        List<Integer>[] left = new ArrayList[n+1];
        List<Integer>[] right = new ArrayList[n+1];
        for (int i = 0; i <= n; ++i) {
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

        // Sort right arrays for binary search
        for (int i = 0; i <= n; ++i) {
            Collections.sort(right[i]);
        }

        int diff = Integer.MAX_VALUE;

        // Minimize the difference using binary search
        for (int i = 0; i <= n; ++i) {
            for (int lSum : left[i]) {
                int complement = (total >> 1) - lSum;
                List<Integer> rList = right[n - i];

                // Binary search to find the closest sums in rList
                int idx = Collections.binarySearch(rList, complement);

                // Check closest values
                if (idx >= 0) {
                    int rSum = rList.get(idx);
                    int sum = lSum + rSum;
                    diff = Math.min(diff, absoluteDiff(sum, total - sum));
                    continue;
                }

                idx = -idx - 1;
                int rSum = idx > 0 ? rList.get(idx - 1) : rList.get(0);
                int sum = lSum + rSum;
                diff = Math.min(diff, absoluteDiff(sum, total - sum));
            }
        }
        return diff;
    }
}