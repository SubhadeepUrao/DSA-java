import java.util.Arrays;

class Solution {
    int minCost(int[] cuts, int i, int j, Integer[][] dp) {
        if (i > j) return 0;

        if(dp[i][j] != null) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for (int k = i; k <= j; ++k) {
            int left = minCost(cuts, i, k - 1, dp);
            int right = minCost(cuts, k + 1, j, dp);
            mini = Math.min(mini, left + right);
        }
        return dp[i][j] = mini + cuts[j + 1] - cuts[i - 1];
    }

    public int minCost(int length, int[] cuts) {
        int N = cuts.length;
        Arrays.sort(cuts);
        int[] temp = new int[N + 2];

        int i = 1;
        for (int cut : cuts) temp[i++] = cut;
        temp[0] = 0;
        temp[N + 1] = length;

        Integer[][] dp = new Integer[N+1][N+1];
        return minCost(temp, 1, N, dp);
    }
}