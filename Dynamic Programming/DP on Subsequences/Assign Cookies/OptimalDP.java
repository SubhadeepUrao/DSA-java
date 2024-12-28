import java.util.Arrays;

// TIME LIMIT EXCEEDED
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // Sort greed factors
        Arrays.sort(s); // Sort cookie sizes
        int N = g.length;
        int M = s.length;

        int[] prev = new int[M+1];
        int[] curr = new int[M+1];

        for(int i = 1; i <= N; ++i) {
            for(int j = 1; j <= M; ++j) {
                if(g[i-1] <= s[j-1])
                    curr[j] = Math.max(prev[j-1] + 1, prev[j-1]);
                else
                    curr[j] = prev[j];
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[M];
    }
}