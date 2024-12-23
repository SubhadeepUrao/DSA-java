class Solution {
    public int minimizeCost(int k, int height[]) {
        int N = height.length;
        int[] dp = new int[N];
        dp[0] = 0;

        for(int i = 1; i < N; ++i) {
            int cost = Integer.MAX_VALUE;
            for(int step = 1; step <= k; ++step) {
                if(i >= step)
                    cost = Math.min(dp[i-step] + Math.abs(height[i] - height[i-step]), cost);
            }
            dp[i] = cost;
        }
        return dp[N-1];
    }
}