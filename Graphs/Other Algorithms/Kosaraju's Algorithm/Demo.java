import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    void buildStack(List<List<Integer>> adj, boolean[] visited, Stack<Integer> st, int node) {
        visited[node] = true;
        for(int neighbour : adj.get(node)) {
            if(!visited[neighbour])
                buildStack(adj, visited, st, neighbour);
        }
        st.push(node);
    }
    void dfs(List<List<Integer>> adjT, boolean[] visited, int node) {
        visited[node] = true;
        for(int neighbour : adjT.get(node)) {
            if(!visited[neighbour])
                dfs(adjT, visited, neighbour);
        }
    }
    int kosaraju(List<List<Integer>> adj) {
        int N = adj.size();
        boolean[] visited = new boolean[N];
        Stack<Integer> st = new Stack<>();

        // Fill the stack with nodes in their finishing order i.e. last finish time will
        // be at top
        buildStack(adj, visited, st, 0);

        List<List<Integer>> adjT = new ArrayList<>();
        for(int i = 0; i < N; ++i)
            adjT.add(new ArrayList<>());
        
        // reverse the graph so that the bridges between SCC's are reversed
        // and dfs traversal for a SCC is contained
        for(int u = 0; u < N; ++u) {
            for(int v : adj.get(u)) {
                adjT.get(v).add(u);
            }
        }

        int SCC = 0;
        Arrays.fill(visited, false);

        // Process all nodes in the order defined by the stack
        while(!st.empty()) {
            int node = st.pop();
            if(!visited[node]) {
                dfs(adjT, visited, node);
                ++SCC;
            }
        }
        return SCC;
    }
}