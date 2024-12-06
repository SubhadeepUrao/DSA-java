import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int[] parent, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        parent[node] = -1;
        
        while(!q.isEmpty()) {
            int currNode = q.poll();
            for(int neighbour : adj.get(currNode)) {
                if(parent[neighbour] == -2) {
                    q.offer(neighbour);
                    parent[neighbour] = currNode;
                }
                else if(neighbour != parent[currNode])
                    return true;
            }
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
            if(parent[node] == -2 && detectCycle(adj, parent, node)) 
                return true;
        }
        return false;
    }
}