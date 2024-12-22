import java.util.ArrayList;
import java.util.List;

class Solution {
    // idea is, while following dfs routine and assigning time value to each call, when
    // we come across a bridge[u,v], then lowestTimeReachable of v will always be
    // greater than the discovery time of u
    // during moonwalking the dfs path
    // this property will always hold if a bridge falls on dfs path

    List<List<Integer>> bridges;
    boolean[] visited;
    int[] discoveryTime;
    int[] lowestTimeAccess;
    int time = 0;

    List<Integer>[] toGraph(int n, List<List<Integer>> edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i)
            adj[i] = new ArrayList<>();

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }
        return adj;
    }

    void dfs(List<Integer>[] adj, int node, int parent) {

        discoveryTime[node] = lowestTimeAccess[node] = ++time;
        visited[node] = true;

        for (int neighbour : adj[node]) {
            if(parent == neighbour) continue;

            if(!visited[neighbour]) {
                dfs(adj, neighbour, node);
                lowestTimeAccess[node] = Math.min(lowestTimeAccess[node], lowestTimeAccess[neighbour]);
                if(lowestTimeAccess[neighbour] > discoveryTime[node])
                    bridges.add(List.of(node, neighbour));
            }
            else {
                lowestTimeAccess[node] = Math.min(lowestTimeAccess[node], lowestTimeAccess[neighbour]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] adj = toGraph(n, connections);

        visited = new boolean[n];
        discoveryTime = new int[n];
        lowestTimeAccess = new int[n];
        bridges = new ArrayList<>();

        dfs(adj, 0, -1);
        return bridges;
    }
}