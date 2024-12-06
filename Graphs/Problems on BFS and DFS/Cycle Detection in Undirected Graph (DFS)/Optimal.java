import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int[] parent, int node) {
        for(int neighbour : adj.get(node)) {
            if(parent[neighbour] == -2) {
                parent[neighbour] = node;
                if(detectCycle(adj, parent, neighbour)) return true;
            }
            else if(neighbour != parent[node]) return true;
        }
        
        return false;
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] parent = new int[V];
        // parent[node] = -2 to indicate unvisited nodes and parent[node] = -1 for the
        // root of the BFS traversal and rest values to track parents
        Arrays.fill(parent, -2);
        
        for(int node = 0; node < V; ++node) {
            if(parent[node] == -2) {
                parent[node] = -1;
                if(detectCycle(adj, parent, node)) return true;
            }
        }
        return false;
    }
}