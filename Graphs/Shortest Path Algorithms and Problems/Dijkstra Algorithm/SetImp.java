import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first; // vertex
        this.second = second; // distance
    }
}
class Solution {
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        int V = adj.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // TreeSet to store pairs of (vertex, distance)
        // sorted based on distance
        TreeSet<iPair> set = new TreeSet<>((a, b) -> {
            if (a.second != b.second) return Integer.compare(a.second, b.second);
            return Integer.compare(a.first, b.first);
        });

        dist[src] = 0;
        set.add(new iPair(src, 0));

        while (!set.isEmpty()) {
            int u = set.pollFirst().first;

            for (iPair neighbour : adj.get(u)) {
                int v = neighbour.first;
                int weight = neighbour.second;

                // Relaxation step
                if (dist[u] + weight < dist[v]) {
                    set.remove(new iPair(v, dist[v])); // Remove outdated pair if it exists
                    dist[v] = dist[u] + weight;
                    set.add(new iPair(v, dist[v])); // Add updated distance
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int node = 0; node < V; ++node)
            res.add(dist[node]);

        return res;
    }
}