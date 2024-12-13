import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // time complexity : O(V+E)
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for(int node = 0; node < indegree.length; ++node)
            if(indegree[node] == 0)
                q.offer(node);
        
        while(!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for(int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0)
                    q.offer(neighbour);
            }
        }
        return res;
    }
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] indegree = new int[V]; // indegree[node] -> indegree of node

        for(int i = 0; i < V; ++i) {
            for(int node : adj.get(i)) {
                indegree[node]++;
            }
        }
        return bfs(adj, indegree);
    }
}