import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DisjoinSet {
    List<Integer> rank;
    List<Integer> parent;

    DisjoinSet(int N) {
        rank = IntStream.generate(() -> 0).limit(N).boxed().collect(Collectors.toList());
        parent = IntStream.range(0, N).boxed().collect(Collectors.toList());
    }

    // time complexity : O(4*alpha)
    int find(int i) { // also path compresses
        if(parent.get(i) == i) return i;
        
        parent.set(i, find(parent.get(i)));

        return parent.get(i);
    }

    // time complexity : O(4*alpha)
    void union(int X, int Y) {
        int repOfX = find(X); // representative of set X
        int repOfY = find(Y); // representative of set Y

        if(repOfX == repOfY) return; // part of the same set

        if(rank.get(repOfX) < rank.get(repOfY))
            parent.set(repOfX, repOfY);
        else if(rank.get(repOfX) > rank.get(repOfY))
            parent.set(repOfY, repOfX);
        else {
            parent.set(repOfX, repOfY);
            int rank = this.rank.get(repOfY);
            this.rank.set(repOfY, rank + 1);
        }
    }
}
class Triplet implements Comparable<Triplet> {
    int u, v, wt;
    Triplet(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
    public int compareTo(Triplet that) {
        return this.wt - that.wt;
    }
}
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        
        for(int u = 0; u < V; ++u) {
            for(int[] edge : adj.get(u)) {
                int v = edge[0];
                int wt = edge[1];
                pq.offer(new Triplet(u, v, wt));
            }
        }

        DisjoinSet ds = new DisjoinSet(V);
        int edges = 0;
        int minWeight = 0;

        while(edges != V-1) {
            Triplet curr = pq.poll();
            int u = curr.u;
            int v = curr.v;
            int wt = curr.wt;

            if(ds.find(u) != ds.find(v)) {
                ds.union(u, v);
                ++edges;
                minWeight += wt;
            }
        }
        return minWeight;
    }
}