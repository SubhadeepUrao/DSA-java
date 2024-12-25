class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int N = matrix.length;
        int[] prev = new int[N];

        for(int j = 0; j < N; ++j)
            prev[j] = matrix[N-1][j];

        int[] curr = new int[N];
        for(int i = N-2; i >= 0; --i) {
            for(int j = 0; j < N; ++j) {
                int bottomLeft = j > 0 ? prev[j-1] : Integer.MAX_VALUE;
                int bottom = prev[j];
                int bottomRight = j < N-1 ? prev[j+1] : Integer.MAX_VALUE;
                curr[j] = Math.min(bottomLeft, Math.min(bottom, bottomRight)) + matrix[i][j];
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        int sum = Integer.MAX_VALUE;
        for(int j = 0; j < N; ++j)
            sum = Math.min(sum, prev[j]);
        
        return sum;
    }
}