import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int node, dist;

    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    public int compareTo(Pair that) {
        return this.dist - that.dist;
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int processedNodes = 0;
        int weight = 0;

        pq.offer(new Pair(0, 0));

        while (processedNodes != V) {
            Pair curr = pq.poll();
            int u = curr.node;
            int dist = curr.dist;

            if (visited[u]) continue;

            visited[u] = true;
            weight += dist;
            ++processedNodes;

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                if (!visited[v])
                    pq.offer(new Pair(v, edge[1]));
            }
        }
        return weight;
    }
}