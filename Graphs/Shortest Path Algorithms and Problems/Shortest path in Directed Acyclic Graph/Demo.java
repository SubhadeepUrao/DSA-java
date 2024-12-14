import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    void bfs(List<List<Integer>> adj, int[][] weights, int[] dist) {
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);

        q.offer(0);
        dist[0] = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            for(int neighbour : adj.get(node)) {
                if(dist[node] + weights[node][neighbour] < dist[neighbour]) {
                    dist[neighbour] = dist[node] + weights[node][neighbour];
                    q.add(neighbour);
                }
            }
        }
        Arrays.setAll(dist, i -> dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[][] weights = new int[V][V];
        int[] dist = new int[V];

        for(int node = 0; node < V; ++node)
            adj.add(new ArrayList<>());
        for(int e = 0; e < E; ++e) {
            adj.get(edges[e][0]).add(edges[e][1]);
            weights[edges[e][0]][edges[e][1]] = edges[e][2];
        }

        bfs(adj, weights, dist);
        return dist;
    }
}