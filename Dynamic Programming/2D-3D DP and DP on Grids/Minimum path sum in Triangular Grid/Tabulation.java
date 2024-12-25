import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int M = triangle.size();
        int N = triangle.get(M-1).size();
        int[][] dp = new int[M][N];

        for(int j = 0; j < N; ++j)
            dp[M-1][j] = triangle.get(M-1).get(j);
        
        for(int i = M-2; i >= 0; --i) {
            int end = triangle.get(i).size();
            for(int j = 0; j < end; ++j)
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j); 
        }

        return dp[0][0];
    }

    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int M = triangle.size();
    //     int N = triangle.get(M - 1).size();
    //     int[][] dp = new int[M][N];

    //     for (int i = M - 1; i >= 0; --i) {
    //         for (int j = 0; j < N; ++j)
    //             dp[i][j] = triangle.get(i).get(j);
    //         --N;
    //     }

    //     for (int i = M - 2; i >= 0; --i) {
    //         int end = triangle.get(i).size();
    //         for (int j = 0; j < end; ++j)
    //             dp[i][j] += Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
    //     }

    //     return dp[0][0];
    // }
}