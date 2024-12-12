import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    List<Integer> res;

    boolean detectCycleDFS(Map<Integer, ArrayList<Integer>> graph, boolean[] visited, boolean[] visitedPath, int node) {
        visited[node] = true;
        visitedPath[node] = true;

        for(int neighbour : graph.getOrDefault(node, new ArrayList<>())) {
            if(!visited[neighbour] && detectCycleDFS(graph, visited, visitedPath, neighbour)) return true;
            else if(visitedPath[neighbour]) return true;
        }
        res.add(node);
        visitedPath[node] = false;
        return false;
    }
    public int[] isCycle(Map<Integer, ArrayList<Integer>> graph, int V) {
        boolean[] visited = new boolean[V];
        boolean[] visitedPath = new boolean[V];

        for(int node = 0; node < V; ++node) {
            if(!visited[node] && detectCycleDFS(graph, visited, visitedPath, node)) {
                return new int[]{};
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        res = new ArrayList<>();

        for(int i = 0; i < prerequisites.length; ++i) {
            graph.putIfAbsent(prerequisites[i][0], new ArrayList<>());
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        return isCycle(graph, numCourses);
    }
}