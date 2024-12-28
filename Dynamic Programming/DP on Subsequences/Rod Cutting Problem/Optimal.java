class Solution {
    public int cutRod(int[] price) {
        int N = price.length;
        int[] prev = new int[N + 1];
        int length = N;

        for (int i = 1; i <= N; ++i) {
            int cost = price[i - 1];
            for (int j = i; j <= length; ++j) {
                prev[j] = Math.max(prev[j - i] + cost, prev[j]);
            }
        }
        return prev[N];
    }
}
