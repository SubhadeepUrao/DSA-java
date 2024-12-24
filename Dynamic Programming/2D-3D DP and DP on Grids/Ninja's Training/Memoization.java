class Solution {
    int maximumPoints(int arr[][], int i, int j, int[][] dp) {
        if (i == 0) return dp[i][j] = arr[i][j];

        if(dp[i][j] != 0) return dp[i][j];

        int points = 0;
        for (int step = 1; step < 3; ++step) {
            points = Math.max(points, maximumPoints(arr, i - 1, (j + step) % 3, dp));
        }
        return dp[i][j] = points + arr[i][j];
    }

    public int maximumPoints(int arr[][], int N) {
        int[][] dp = new int[N][3];
        int points = 0;
        for (int j = 0; j < 3; ++j)
            points = Math.max(maximumPoints(arr, N - 1, j, dp), points);
        return points;
    }
}