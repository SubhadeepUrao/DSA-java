class Solution{
    public int minimumEnergy(int[] height, int N) {
        int prev = 0;
        int prev2 = 0;

        for(int i = 1; i < N; ++i) {
            int stepOne = prev + Math.abs(height[i] - height[i-1]);
            int stepTwo = i > 1 ? prev2 + Math.abs(height[i] - height[i-2]) : Integer.MAX_VALUE;

            int curr = Math.min(stepOne, stepTwo);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}