import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean[] visited;
    boolean[] visitedPath;
    boolean detectCycleDFS(int[][] graph, int node) {
        visited[node] = true;
        visitedPath[node] = true;

        for(int neighbour : graph[node]) {
            if (!visited[neighbour] && detectCycleDFS(graph, neighbour)) {
                return true; // Cycle detected
            } else if (visitedPath[neighbour]) {
                return true; // Cycle detected (back edge)
            }
        }
        visitedPath[node] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        visited = new boolean[graph.length];
        visitedPath = new boolean[graph.length];
        for(int node = 0; node < graph.length; ++node) {
            if(!detectCycleDFS(graph, node)) {
                res.add(node);
            }
        }
        return res;
    }
}