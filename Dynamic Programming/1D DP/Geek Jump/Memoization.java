import java.util.Arrays;

class Solution{
    public int minimumEnergy(int height[],int i, int[] dp){
        if(i == 0) return dp[i] = 0;

        if(dp[i] != -1) return dp[i];

        int stepOne = minimumEnergy(height, i-1, dp) + Math.abs(height[i] - height[i-1]);
        int stepTwo = i > 1 ? minimumEnergy(height, i-2, dp) + Math.abs(height[i] - height[i-2]) : Integer.MAX_VALUE;

        return dp[i] = Math.min(stepOne, stepTwo);
    }
    public int minimumEnergy(int[] height, int N) {
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        return minimumEnergy(height, N-1, dp);
    }


    // public int minimumEnergy(int height[],int N, int[] dp){
    //     if(N <= 1 || N <= 2) return dp[N] = Math.abs(height[N-1] - height[0]);

    //     if(dp[N] != -1) return dp[N];

    //     int stepOne = minimumEnergy(height, N-1, dp) + Math.abs(height[N-1] - height[N-2]); // Math.abs(height[N-1] - height[N-1-1])
    //     int stepTwo = minimumEnergy(height, N-2, dp) + Math.abs(height[N-1] - height[N-3]); // Math.abs(height[N-1] - height[N-2-1])

    //     return dp[N] = Math.min(stepOne, stepTwo);
    // }
    // public int minimumEnergy(int[] height, int N) {
    //     int[] dp = new int[N+1];
    //     Arrays.fill(dp, -1);
    //     return minimumEnergy(height, N, dp);
    // }
}