class Solution{
    public int minimumEnergy(int[] height, int N) {
        int[] dp = new int[N];
        dp[0] = 0;

        for(int i = 1; i < N; ++i) {
            int stepOne = dp[i-1] + Math.abs(height[i] - height[i-1]);
            int stepTwo = i > 1 ? dp[i-2] + Math.abs(height[i] - height[i-2]) : Integer.MAX_VALUE;

            dp[i] = Math.min(stepOne, stepTwo);
        }
        return dp[N-1];
    }
}