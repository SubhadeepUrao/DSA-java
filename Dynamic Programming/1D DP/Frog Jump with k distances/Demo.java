class Solution {
    int solve(int k, int[] height, int i) {
        if(i == 0) return 0;
        int cost = Integer.MAX_VALUE;
        for(int step = 1; step <= k; ++step) {
            cost = Math.min(i >= step ? solve(k, height, i-step) + Math.abs(height[i] - height[i-step]) : Integer.MAX_VALUE, cost);
        }
        return cost;
    }
    public int minimizeCost(int k, int height[]) {
        int N = height.length;
        return solve(k, height, N-1);
    }
}