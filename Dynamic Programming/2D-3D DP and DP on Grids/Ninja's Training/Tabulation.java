class Solution {
    public int maximumPoints(int arr[][], int N) {
        int[][] dp = new int[N][3];

        for(int j = 0; j < 3; ++j)
            dp[0][j] = arr[0][j];
        
        for(int i = 1; i < N; ++i) {
            for(int j = 0; j < 3; ++j) {
                int points = 0;
                for(int step = 1; step < 3; ++step) {
                    points = Math.max(points, dp[i-1][(j + step) % 3]);
                }
                dp[i][j] = points + arr[i][j];
            }
        }
        int points = 0;
        for (int j = 0; j < 3; ++j)
            points = Math.max(dp[N-1][j], points);
        return points;
    }
}