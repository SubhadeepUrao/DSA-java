class Solution {
    static int MCM(int[] arr, int i, int j) {
        if (i + 1 == j) return 0;

        int mini = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; ++k) {
            int left = MCM(arr, i, k);
            int right = MCM(arr, k, j);
            mini = Math.min(mini, left + right + arr[i] * arr[k] * arr[j]);
        }
        return mini;
    }

    static int matrixMultiplication(int arr[]) {
        int N = arr.length;
        return MCM(arr, 0, N - 1);
    }
}