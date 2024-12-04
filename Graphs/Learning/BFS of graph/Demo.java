import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        
        q.add(0);
        visited[0] = true;
        
        while(!q.isEmpty()) {
            int currNode = q.poll();
            bfs.add(currNode);
            
            for(int node : adj.get(currNode)) {
                if(!visited[node]) {
                    visited[node] = true;
                    q.add(node);
                }
            }
        }
        return bfs;
    }

    // public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    //     ArrayList<Integer> bfs = new ArrayList<>();
    //     Queue<Integer> q = new LinkedList<>();
    //     boolean[] visited = new boolean[V];

    //     q.add(0);
    //     while (!q.isEmpty()) {
    //         int currNode = q.poll();
    //         if (!visited[currNode]) {
    //             bfs.add(currNode);
    //             visited[currNode] = true;
    //             for (int node : adj.get(currNode))
    //                 if (!visited[node])
    //                     q.add(node);
    //         }
    //     }
    //     return bfs;
    // }
}