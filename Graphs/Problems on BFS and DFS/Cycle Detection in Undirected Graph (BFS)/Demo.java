import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    boolean detectCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] parent, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        parent[node] = -1;
        visited[node] = true;
        
        while(!q.isEmpty()) {
            int currNode = q.poll();
            for(int neighbour : adj.get(currNode)) {
                if(!visited[neighbour]) {
                    q.offer(neighbour);
                    visited[neighbour] = true;
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
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        
        for(int node = 0; node < V; ++node) {
            if(!visited[node] && detectCycle(adj, visited, parent, node)) 
                return true;
        }
        return false;
    }
}