import java.util.Arrays;

class Solution {
    int solve(int k, int[] height, int i, int[] dp) {
        if(i == 0) return dp[0] = 0;

        if(dp[i] != -1) return dp[i];

        int cost = Integer.MAX_VALUE;
        for(int step = 1; step <= k; ++step) {
            cost = Math.min(i >= step ? solve(k, height, i-step, dp) + Math.abs(height[i] - height[i-step]) : Integer.MAX_VALUE, cost);
        }
        return cost;
    }
    public int minimizeCost(int k, int height[]) {
        int N = height.length;
        int[] dp = new int[N];
        Arrays.fill(dp, -1);

        return solve(k, height, N-1, dp);
    }
}