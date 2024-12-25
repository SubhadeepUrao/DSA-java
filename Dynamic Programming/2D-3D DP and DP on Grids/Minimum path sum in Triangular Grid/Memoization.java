import java.util.ArrayList;
import java.util.List;

class Solution {
    int minimumTotal(List<List<Integer>> triangle, int i, int j, List<Integer>[] dp) {
        if (i + 1 == triangle.size())
            return triangle.get(i).get(j);
        if (dp[i].get(j) != Integer.MAX_VALUE)
            return dp[i].get(j);

        int res = Math.min(minimumTotal(triangle, i + 1, j, dp), minimumTotal(triangle, i + 1, j + 1, dp))
                + triangle.get(i).get(j);
        dp[i].set(j, res);
        return res;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();
        List<Integer>[] dp = new ArrayList[N];

        for (int i = 0; i < N; ++i) {
            dp[i] = new ArrayList<>();
            int M = triangle.get(i).size();
            for (int j = 0; j < M; ++j) {
                dp[i].add(Integer.MAX_VALUE);
            }
        }

        return minimumTotal(triangle, 0, 0, dp);
    }
}