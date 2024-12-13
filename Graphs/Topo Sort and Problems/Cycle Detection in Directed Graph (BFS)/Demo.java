import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    boolean detectCycleBFS(ArrayList<ArrayList<Integer>> adj, int[] indegree) {
        int V = indegree.length;
        Queue<Integer> q = new LinkedList<>();
        int[] topoSeq = new int[V];
        int next = 0;

        for(int i = 0; i < V; ++i) {
            if(indegree[i] == 0)
                q.offer(i);
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            topoSeq[next++] = node;

            for(int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0)
                    q.offer(neighbour);
            }
        }
        return next == V ? true : false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];

        for(int i = 0; i < V; ++i)
            for(int node : adj.get(i))
                indegree[node]++;
        
        return detectCycleBFS(adj, indegree);
    }
}