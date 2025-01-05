class Solution {
    int solve(int[] arr, int k, int i, int j) {
        if (i > j)  return 0;
        if (i == j) return arr[i];

        int maxi = 0, lmax = 0;
        int n = Math.min(i + k - 1, j);
        for (int ind = i; ind <= n; ++ind) {
            lmax = Math.max(lmax, arr[ind]);
            maxi = Math.max(maxi, lmax * (ind - i + 1) + solve(arr, k, ind + 1, j));
        }
        return maxi;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length;
        return solve(arr, k, 0, N - 1);
    }
}