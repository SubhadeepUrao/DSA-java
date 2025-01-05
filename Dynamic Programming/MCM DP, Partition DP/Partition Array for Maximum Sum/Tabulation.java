class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length;
        int[] dp = new int[N + 1];

        for (int i = N - 1; i >= 0; --i) {
            int maxi = 0, lmax = 0;
            int n = Math.min(i + k - 1, N - 1);
            for (int ind = i; ind <= n; ++ind) {
                lmax = Math.max(lmax, arr[ind]);
                maxi = Math.max(maxi, lmax * (ind - i + 1) + dp[ind + 1]);
            }
            dp[i] = maxi;
        }
        return dp[0];
    }
}