import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean[] visited;
    boolean[] visitedPath;
    
    boolean detectCycleDFS(List<List<Integer>> adj, int node) {
        visited[node] = true;
        visitedPath[node] = true;

        for(int neighbour : adj.get(node)) {
            if(!visited[neighbour] && detectCycleDFS(adj, neighbour))
                return true;
            else if(visitedPath[neighbour]) return true;
        }
        visitedPath[node] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; ++i)
            adj.add(new ArrayList<>());

        for(int i = 0; i < prerequisites.length; ++i)
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);

        visited = new boolean[numCourses];
        visitedPath = new boolean[numCourses];
        for(int node = 0; node < numCourses; ++node) {
            if(!visited[node] && detectCycleDFS(adj, node))
                return false;
        }
        return true;
    }
}