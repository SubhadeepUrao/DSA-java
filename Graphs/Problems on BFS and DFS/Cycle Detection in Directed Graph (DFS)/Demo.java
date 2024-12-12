import java.util.ArrayList;

class Solution {
    boolean detectCycleDFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] visitedPath, int node) {
        visited[node] = true;
        visitedPath[node] = true;

        for(int neighbour : adj.get(node)) {
            if(!visited[neighbour] && detectCycleDFS(adj, visited, visitedPath, neighbour)) return true;
            else if(visitedPath[neighbour]) return true;
        }

        visitedPath[node] = false;
        return false;
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        boolean[] visitedPath = new boolean[V];

        for(int node = 0; node < V; ++node) {
            if(!visited[node] && detectCycleDFS(adj, visited, visitedPath, node)) {
                return true;
            }
        }
        return false;
    }
}