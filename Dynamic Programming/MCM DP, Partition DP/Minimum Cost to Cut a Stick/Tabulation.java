import java.util.Arrays;

class Solution {
    public int minCost(int length, int[] cuts) {
        int N = cuts.length;
        Arrays.sort(cuts);
        int[] temp = new int[N + 2];

        int i = 1;
        for (int cut : cuts)
            temp[i++] = cut;
        temp[0] = 0;
        temp[N + 1] = length;

        int[][] dp = new int[N + 2][N + 2];

        for (i = N; i >= 1; --i) {
            for (int j = i; j <= N; ++j) {
                int mini = Integer.MAX_VALUE;
                for (int k = i; k <= j; ++k) {
                    int left = dp[i][k - 1];
                    int right = dp[k + 1][j];
                    mini = Math.min(mini, left + right);
                }
                dp[i][j] = mini + temp[j + 1] - temp[i - 1];
            }
        }

        return dp[1][N];
    }

    // public int minCost(int length, int[] cuts) {
    //     int N = cuts.length;
    //     Arrays.sort(cuts);
    //     int[] temp = new int[N + 2];

    //     int i = 1;
    //     for (int cut : cuts)
    //         temp[i++] = cut;
    //     temp[0] = 0;
    //     temp[N + 1] = length;

    //     int[][] dp = new int[N + 2][N + 2];

    //     for (i = N; i >= 1; --i) {
    //         for (int j = 1; j <= N; ++j) {
    //             if (i > j) continue;

    //             int mini = Integer.MAX_VALUE;
    //             for (int k = i; k <= j; ++k) {
    //                 int left = dp[i][k - 1];
    //                 int right = dp[k + 1][j];
    //                 mini = Math.min(mini, left + right);
    //             }
    //             dp[i][j] = mini + temp[j + 1] - temp[i - 1];
    //         }
    //     }

    //     return dp[1][N];
    // }
}