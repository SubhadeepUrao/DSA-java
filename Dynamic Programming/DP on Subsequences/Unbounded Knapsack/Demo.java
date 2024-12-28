class Solution {
    static int knapSack(int[] val, int[] wt, int i, int capacity) {
        if (capacity == 0 || i < 0) return 0;

        if (capacity >= wt[i])
            return Math.max(knapSack(val, wt, i, capacity - wt[i]) + val[i], knapSack(val, wt, i - 1, capacity));
        return knapSack(val, wt, i - 1, capacity);
    }

    static int knapSack(int val[], int wt[], int capacity) {
        int N = val.length;
        return knapSack(val, wt, N - 1, capacity);
    }
}