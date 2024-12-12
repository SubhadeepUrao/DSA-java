import java.util.ArrayList;

class Solution {
    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, ArrayList<Integer> res) {
        visited[node] = true;

        for(int neighbour : adj.get(node)) {
            if(!visited[neighbour])
                dfs(adj, visited, neighbour, res);
        }
        res.add(0, node); // used instead of Stack
    }
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();

        for(int node = 0; node < V; ++node) {
            if(!visited[node])
                dfs(adj, visited, node, res);
        }
        return res;
    }
}