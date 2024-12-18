import java.util.Arrays;

// idea is, an unrestricted path between u to v, cannot have more than n-1 edges without a cycle 
// i.e. if there exists more than n-1 edges, there also exists a cycle
// x----x----x----x----x : unrestricted path contains n-1 edges i.e. no cycle

// time complexity : O(n*e), if e ~ n^2, then O(n^3)
class Solution {

    static int[] bellmanFord(int V, int[][] edges, int src) {
        int MAX = 10000_0000;
        int[] dist = new int[V];
        Arrays.fill(dist, MAX);

        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int e = 0; e < edges.length; ++e) {
                int u = edges[e][0];
                int v = edges[e][1];
                int wt = edges[e][2];
                if (dist[u] != MAX && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for (int e = 0; e < edges.length; ++e) {
            int u = edges[e][0];
            int v = edges[e][1];
            int wt = edges[e][2];
            if (dist[u] != MAX && dist[u] + wt < dist[v]) {
                return new int[] { -1 };
            }
        }
        return dist;
    }
}
