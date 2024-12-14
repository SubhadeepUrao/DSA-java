import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// each node is visited only once

class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first; // node
        this.second = second; // dist
    }
}
class Solution {
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        PriorityQueue<iPair> pq = new PriorityQueue<>((a, b) -> a.first - b.first);
        int V = adj.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        pq.offer(new iPair(0, src));

        while(!pq.isEmpty()) {
            int node = pq.poll().second;
            for(iPair neighbour : adj.get(node)) {
                if(dist[node] + neighbour.first < dist[neighbour.second]) {
                    dist[neighbour.second] = dist[node] + neighbour.first;
                    pq.offer(new iPair(neighbour.first, neighbour.second));
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int node = 0; node < V; ++node)
            res.add(dist[node]);
        
        return res;
    }
}