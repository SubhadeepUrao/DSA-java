class Solution {
    int maximumPoints(int arr[][], int i, int j) {
        if (i == 0) return arr[i][j];

        int points = 0;
        for (int step = 1; step < 3; ++step) {
            points = Math.max(points, maximumPoints(arr, i - 1, (j + step) % 3));
        }
        return points + arr[i][j];
    }

    public int maximumPoints(int arr[][], int N) {
        int points = 0;
        for (int j = 0; j < 3; ++j)
            points = Math.max(maximumPoints(arr, N - 1, j), points);
        return points;
    }
}