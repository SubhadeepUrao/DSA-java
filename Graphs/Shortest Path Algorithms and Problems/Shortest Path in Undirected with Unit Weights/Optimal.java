import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    void bfs(List<List<Integer>> adj , int src, int[] dist) {
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);

        q.offer(src);
        dist[src] = 0;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int neighbour : adj.get(node)) {
                if(dist[node] + 1 < dist[neighbour]) {
                    dist[neighbour] = dist[node] + 1;
                    q.offer(neighbour);
                }
            }
        }
        // for(int i = 0; i < dist.length; ++i)
        //     if(dist[i] == Integer.MAX_VALUE)
        //         dist[i] = -1;
        Arrays.setAll(dist, i -> dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
    }
    List<List<Integer>> graphify(int[][] edges, int n, int m) {
        // n = #nodes
        // m = #edges
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        
        for(int i = 0; i < m; ++i) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        return adj;
    }
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        List<List<Integer>> adj = graphify(edges, n, m);
        int[] dist = new int[n];
        bfs(adj, src, dist);
        return dist;
    }
}