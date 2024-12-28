class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        int N = val.length;
        int[] prev = new int[capacity + 1];

        for (int i = 1; i <= N; ++i) {
            int weight = wt[i - 1];
            int value = val[i - 1];
            for (int j = weight; j <= capacity; ++j) {
                prev[j] = Math.max(prev[j - weight] + value, prev[j]);
            }
        }
        return prev[capacity];
    }
}