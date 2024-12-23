// Top-Down approach
class Solution {
    int climbStairs(int i, int[] dp) {
        if(i == 0) return dp[i] = 1;
        if(i < 0) return 0;

        if(dp[i] != 0) return dp[i];

        return dp[i] = climbStairs(i-1, dp) + climbStairs(i-2, dp);
    }
    public int climbStairs(int n) {

        return climbStairs(n, new int[n+1]);
    }
}