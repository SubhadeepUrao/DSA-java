import java.util.HashSet;
import java.util.Set;

class Solution {
    boolean dfs(int[][] graph, int node, Set<Integer> A, Set<Integer> B) {
        if(!A.contains(node) && !B.contains(node))
            A.add(node);

        for(int neighbour : graph[node]) {
            if(A.contains(neighbour)) return false;
            if(!B.contains(neighbour) && !dfs(graph, neighbour, B, A)) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();

        for(int node = 0; node < graph.length; ++node) {
            if(!A.contains(node) && !B.contains(node) && !dfs(graph, node, A, B)) return false;
        }
        return true;
    }
}