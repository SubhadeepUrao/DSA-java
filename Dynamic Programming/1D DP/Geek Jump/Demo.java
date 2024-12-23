class Solution{
    public int minimumEnergy(int height[],int N){
        if(N-1 <= 0 || N-2 <= 0) return Math.abs(height[N-1] - height[0]);

        int stepOne = minimumEnergy(height, N-1) + Math.abs(height[N-1] - height[N-2]); // Math.abs(height[N-1] - height[N-1-1])
        int stepTwo = minimumEnergy(height, N-2) + Math.abs(height[N-1] - height[N-3]); // Math.abs(height[N-1] - height[N-2-1])

        return Math.min(stepOne, stepTwo);
    }
}