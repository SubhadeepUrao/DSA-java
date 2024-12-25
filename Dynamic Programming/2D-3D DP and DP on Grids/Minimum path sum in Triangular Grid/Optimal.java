import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int M = triangle.size();
        int N = triangle.get(M-1).size();
        int[] dp = new int[N];

        for(int j = 0; j < N; ++j)
            dp[j] = triangle.get(M-1).get(j);
        
        for(int i = M-2; i >= 0; --i) {
            int end = triangle.get(i).size();
            for(int j = 0; j < end; ++j)
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
        }

        return dp[0];
    }
}