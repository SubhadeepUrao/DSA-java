class Solution {
    public int maximumPoints(int arr[][], int N) {
        int[] prev = new int[3];

        for(int i = 0; i < 3; ++i)
            prev[i] = arr[0][i];
        
        for(int i = 1; i < N; ++i) {
            int[] temp = new int[3];
            for(int j = 0; j < 3; ++j) {
                int points = 0;
                for(int step = 1; step < 3; ++step) {
                    points = Math.max(points, prev[(j + step) % 3]);
                }
                temp[j] = points + arr[i][j];
            }
            prev = temp;
        }
        int points = 0;
        for (int j = 0; j < 3; ++j)
            points = Math.max(prev[j], points);
        return points;
    }
}