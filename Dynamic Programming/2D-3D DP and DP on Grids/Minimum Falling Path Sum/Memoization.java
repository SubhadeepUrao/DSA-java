class Solution {
    int minFallingPathSum(int[][] matrix, int i, int j, int N, int[][] dp, boolean[][] visited) {
        if(i == N) return 0;
        if(j < 0 || j == N) return Integer.MAX_VALUE;

        if(!visited[i][j]) {
            visited[i][j] = true;
            int left = minFallingPathSum(matrix, i+1, j-1, N, dp, visited);
            int mid = minFallingPathSum(matrix, i+1, j, N, dp, visited);
            int right = minFallingPathSum(matrix, i+1, j+1, N, dp, visited);
            dp[i][j] = Math.min(left, Math.min(mid, right)) + matrix[i][j];
        }
        return dp[i][j];
    }
    public int minFallingPathSum(int[][] matrix) {
        int sum = Integer.MAX_VALUE;
        int N = matrix.length;
        boolean[][] visited = new boolean[N][N];
        int[][] dp = new int[N][N];

        for(int j = 0; j < N; ++j) {
            sum = Math.min(sum, minFallingPathSum(matrix, 0, j, N, dp, visited));
        }
        return sum;
    }
}