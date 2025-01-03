import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        int[] previous = new int[N];

        int maxi = 0;
        Arrays.fill(previous, -1);
        Arrays.sort(nums);

        dp[0] = 1;

        for (int i = 1; i < N; ++i) {
            int lmax = 0;
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0 && lmax < dp[j]) {
                    lmax = dp[j];
                    previous[i] = j;
                }
            }
            dp[i] = lmax + 1;
            if (dp[maxi] < dp[i]) {
                maxi = i;
            }
        }

        List<Integer> list = new LinkedList<>();
        list.add(nums[maxi]);
        int i = maxi;
        while (previous[i] != -1) {
            i = previous[i];
            list.add(0, nums[i]);
        }
        return list;
    }
}