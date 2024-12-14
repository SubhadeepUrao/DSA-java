import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    void dfs(List<List<Integer>> adj, boolean[] visited, Stack<Integer> topoSort, int node) {
        visited[node] = true;

        for(int neighbour : adj.get(node)) {
            if(!visited[neighbour])
                dfs(adj, visited, topoSort, neighbour);
        }
        topoSort.push(node);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[][] weights = new int[V][V];
        int[] dist = new int[V];
        int src = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int node = 0; node < V; ++node)
            adj.add(new ArrayList<>());
        for(int e = 0; e < E; ++e) {
            adj.get(edges[e][0]).add(edges[e][1]);
            weights[edges[e][0]][edges[e][1]] = edges[e][2];
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> topoSort = new Stack<>();
        for(int node = 0; node < V; ++node) {
            if(!visited[node])
                dfs(adj, visited, topoSort, node);
        }

        while(topoSort.peek() != src) {
            dist[topoSort.pop()] = -1;
        }
        
        while(!topoSort.empty()) {
            int node = topoSort.pop();
            for(int neighbour : adj.get(node)) {
                if(dist[node] + weights[node][neighbour] < dist[neighbour]) {
                    dist[neighbour] = dist[node] + weights[node][neighbour];
                }
            }
        }

        return dist;
    }
}