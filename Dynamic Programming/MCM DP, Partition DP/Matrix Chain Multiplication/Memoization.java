class Solution {
    static int MCM(int[] arr, int i, int j, Integer[][] dp) {
        if (i + 1 == j) return 0;

        if (dp[i][j] != null) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; ++k) {
            int left = MCM(arr, i, k, dp);
            int right = MCM(arr, k, j, dp);
            mini = Math.min(mini, left + right + arr[i] * arr[k] * arr[j]);
        }
        return dp[i][j] = mini;
    }

    static int matrixMultiplication(int arr[]) {
        int N = arr.length;
        Integer[][] dp = new Integer[N][N];
        return MCM(arr, 0, N - 1, dp);
    }
}