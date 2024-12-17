import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int intersection;
    long timeSpent;

    Pair(int intersection, long timeSpent) {
        this.intersection = intersection;
        this.timeSpent = timeSpent;
    }
    public int compareTo(Pair that) {
        return (int)(this.timeSpent - that.timeSpent);
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        // Step 1: Build the graph using adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        for (int[] info : roads) {
            adj.get(info[0]).add(new Pair(info[1], info[2]));
            adj.get(info[1]).add(new Pair(info[0], info[2]));
        }

        // Step 2: Dijkstra's algorithm initialization
        long[] delay = new long[n];
        Arrays.fill(delay, Long.MAX_VALUE);
        int[] ways = new int[n]; // To track the number of ways
        ways[0] = 1; // There's 1 way to reach the starting node
        delay[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.timeSpent));
        pq.offer(new Pair(0, 0)); // Starting at intersection 0

        // Step 3: Dijkstra's algorithm with path counting
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.intersection;
            long time = curr.timeSpent;

            if (time > delay[u]) continue; // skip outdated pair

            for (Pair neighbour : adj.get(u)) {
                int v = neighbour.intersection;
                long timeSpent = neighbour.timeSpent;

                if (delay[u] + timeSpent < delay[v]) {
                    // Found a new shortest path to v
                    delay[v] = delay[u] + timeSpent;
                    ways[v] = ways[u]; // Propagate the path count
                    pq.offer(new Pair(v, delay[v]));
                } else if (delay[u] + timeSpent == delay[v]) {
                    // Found another shortest path to v
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[n - 1] % MOD;
    }
}
