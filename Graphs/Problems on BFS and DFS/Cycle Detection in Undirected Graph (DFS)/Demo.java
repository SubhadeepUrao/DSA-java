import java.util.ArrayList;

class Solution {
    boolean detectCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] parent, int node) {
        visited[node] = true;
        
        for(int neighbour : adj.get(node)) {
            if(!visited[neighbour]) {
                parent[neighbour] = node;
                if(detectCycle(adj, visited, parent, neighbour)) return true;
            }
            else if(neighbour != parent[node]) return true;
        }
        
        return false;
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        
        for(int node = 0; node < V; ++node) {
            if(!visited[node]) {
                parent[node] = -1;
                if(detectCycle(adj, visited, parent, node)) return true;
            }
        }
        return false;
    }
}