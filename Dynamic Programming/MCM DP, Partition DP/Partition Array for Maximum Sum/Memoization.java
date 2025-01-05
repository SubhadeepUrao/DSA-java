class Solution {
    int solve(int[] arr, int k, int i, int j, Integer[] dp) {
        if (i > j) return 0;
        if (i == j) return arr[i];

        if (dp[i] != null) return dp[i];

        int maxi = 0, lmax = 0;
        int n = Math.min(i + k - 1, j);
        for (int ind = i; ind <= n; ++ind) {
            lmax = Math.max(lmax, arr[ind]);
            maxi = Math.max(maxi, lmax * (ind - i + 1) + solve(arr, k, ind + 1, j, dp));
        }
        return dp[i] = maxi;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length;
        Integer[] dp = new Integer[N];
        return solve(arr, k, 0, N - 1, dp);
    }
}