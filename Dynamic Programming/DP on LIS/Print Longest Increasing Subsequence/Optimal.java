import java.util.ArrayList;
import java.util.Arrays;

class Optimal {
    // Not Index-wise lexicographically smallest
    public static ArrayList<Integer> longestIncreasingSubsequence(int N, int nums[]) {
        int[] dp = new int[N];
        int[] previous = new int[N];

        Arrays.fill(dp, 1);
        Arrays.fill(previous, -1);
        int maxi = 0;
        dp[0] = 1;

        for(int i = 1; i < N; ++i) {
            for(int prev = i-1; prev >= 0; --prev) {
                if(nums[prev] < nums[i] && dp[i] < dp[prev] + 1) {
                    dp[i] = dp[prev] + 1;
                    previous[i] = prev;
                }
            }
            if(dp[maxi] < dp[i])
                maxi = i;
        }

        int i = maxi;
        ArrayList<Integer> seq = new ArrayList<>();

        seq.add(nums[maxi]);
        while(previous[i] != -1) {
            i = previous[i];
            seq.add(0, nums[i]);
        }
        return seq;
    }
}
