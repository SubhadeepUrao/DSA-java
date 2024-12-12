import java.util.ArrayList;
import java.util.List;

class Solution {
    int[] res;
    int next = 0;

    boolean detectCycleDFS(List<List<Integer>> graph, boolean[] visited, boolean[] visitedPath, int node) {
        visited[node] = true;
        visitedPath[node] = true;

        for(int neighbour : graph.get(node)) {
            if(!visited[neighbour] && detectCycleDFS(graph, visited, visitedPath, neighbour)) return true;
            else if(visitedPath[neighbour]) return true;
        }
        res[next++] = node;
        visitedPath[node] = false;
        return false;
    }
    public int[] isCycle(List<List<Integer>> graph, int V) {
        boolean[] visited = new boolean[V];
        boolean[] visitedPath = new boolean[V];

        for(int node = 0; node < V; ++node) {
            if(!visited[node] && detectCycleDFS(graph, visited, visitedPath, node)) {
                return new int[]{};
            }
        }

        return res;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        res = new int[numCourses];

        for(int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<>());
        for(int i = 0; i < prerequisites.length; ++i)
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);

        return isCycle(graph, numCourses);
    }
}