import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// same node might be visited multiple times

class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    ArrayList<Integer> bfs(ArrayList<ArrayList<iPair>> adj, int src) {
        int[] dist = new int[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        q.offer(src);
        dist[src] = 0;
        
        while(!q.isEmpty()) {
            int node = q.poll();
            for(iPair neighbour : adj.get(node)) {
                if(dist[node] + neighbour.second < dist[neighbour.first]) {
                    dist[neighbour.first] = dist[node] + neighbour.second;
                    q.offer(neighbour.first);
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < adj.size(); ++i) {
            res.add(dist[i]);
        }
        return res;
    }
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        return bfs(adj, src);
    }
}