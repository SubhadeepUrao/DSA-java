import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
                int complement = (total / 2) - lSum;
                List<Integer> rList = right[n - i];

                // Binary search to find the closest sums in rList
                int idx = Collections.binarySearch(rList, complement);
                if (idx < 0) idx = -idx - 1;

                // Check closest values
                if (idx < rList.size()) {
                    int rSum = rList.get(idx);
                    int sum = lSum + rSum;
                    diff = Math.min(diff, absoluteDiff(sum, total - sum));
                }
                if (idx > 0) {
                    int rSum = rList.get(idx - 1);
                    int sum = lSum + rSum;
                    diff = Math.min(diff, absoluteDiff(sum, total - sum));
                }
            }
        }

        return diff;
    }
}