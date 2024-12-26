class Solution {
    static Boolean isSubsetSum(int arr[], int target) {
        int N = arr.length;
        boolean[][] dp = new boolean[N][target + 1];

        for(int i = 0; i < N; ++i)
            dp[i][0] = true;

        if(target >= arr[0])
            dp[0][arr[0]] = true;

        for(int i = 1; i < N; ++i) {
            for(int j = 1; j <= target; ++j) {
                boolean take = j >= arr[i] ? dp[i-1][j - arr[i]] : false;
                boolean notTake = dp[i-1][j];
                dp[i][j] = take || notTake;
                // dp[i][j]: Represents whether it is possible to achieve a sum of j using the first i+1
                // elements of the array.
            }
        }

        return dp[N-1][target];
    }
}