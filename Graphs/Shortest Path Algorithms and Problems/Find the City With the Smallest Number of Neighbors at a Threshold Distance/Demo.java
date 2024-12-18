import java.util.Arrays;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        // By setting MAX = Integer.MAX_VALUE / 2, any valid addition of two distances:
        // dist[i][k] + dist[k][j] <= MAX + MAX = Integer.MAX_VALUE
        // This prevents the sum from exceeding the range of a 32-bit integer.
        int MAX = Integer.MAX_VALUE >> 1;

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dist[i], MAX);
            dist[i][i] = 0; // Distance to self is 0.
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            dist[u][v] = edge[2];
            dist[v][u] = edge[2];
        }

        // Flyod Warshal Algo
        for (int k = 0; k < n; ++k)
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        int city = 0, miniCnt = MAX;
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            for (int j = 0; j < n; ++j) {
                if (dist[i][j] <= distanceThreshold)
                    ++cnt;
            }
            if (cnt <= miniCnt) {
                miniCnt = cnt;
                city = i;
            }
        }
        return city;
    }

}