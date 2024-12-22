import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    boolean[] visited;
    int[] discoveryTime;
    int[] lowestTimeReachable;
    boolean[] mark;
    int timer = 0;

    void dfs(ArrayList<ArrayList<Integer>> adj, int node, int parent) {
        discoveryTime[node] = lowestTimeReachable[node] = ++timer;
        visited[node] = true;
        int child = 0;

        for(int neighbour : adj.get(node)) {
            if(neighbour == parent) continue;

            if(!visited[neighbour]) {
                ++child;
                dfs(adj, neighbour, node);
                lowestTimeReachable[node] = Math.min(lowestTimeReachable[node], lowestTimeReachable[neighbour]);
                
                if(lowestTimeReachable[neighbour] >= discoveryTime[node] && parent != -1)
                    mark[node] = true;
            }
            else 
                lowestTimeReachable[node] = Math.min(lowestTimeReachable[node], discoveryTime[neighbour]);
                // for an articulation point, discovery time of all nodes greater or equals to
                // that point's discovery time cannot access lower discovery time
        }
        if(parent == -1 && child > 1)
            mark[node] = true;
    }

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        if (V < 3) return new ArrayList<>(Arrays.asList(-1)); // No mark points in graphs with fewer than 3 vertices
        
        visited = new boolean[V];
        discoveryTime = new int[V];
        lowestTimeReachable = new int[V];
        mark = new boolean[V];

        dfs(adj, 0, -1);

        ArrayList<Integer> points = new ArrayList<>();
        for(int i = 0; i < V; ++i)
            if(mark[i])
                points.add(i);
        
        return points.size() > 0 ? points : new ArrayList<>(Arrays.asList(-1));
    }
}