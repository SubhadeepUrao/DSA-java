import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class Solution {
    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, Stack<Integer> st) {
        visited[node] = true;

        for(int neighbour : adj.get(node)) {
            if(!visited[neighbour])
                dfs(adj, visited, neighbour, st);
        }
        st.add(node); // store the node in Stack
    }
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int node = 0; node < V; ++node) {
            if(!visited[node])
                dfs(adj, visited, node, st);
        }

        Collections.reverse(st);
        return new ArrayList<>(st);
    }
}