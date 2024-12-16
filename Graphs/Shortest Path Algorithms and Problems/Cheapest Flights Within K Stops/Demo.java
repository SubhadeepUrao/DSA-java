import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// same as shortest path in DAG
class Solution {
    class Tuple {
        int price, node, stops;
        Tuple(int price, int node, int stops) {
            this.price = price;
            this.node = node;
            this.stops = stops;
        }
    }
    class Pair {
        int price, node;
        Pair(int price, int node) {
            this.price = price;
            this.node = node;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        for (int[] info : flights)
            adj.get(info[0]).add(new Pair(info[2], info[1]));

        int[] price = new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);

        Queue<Tuple> pq = new LinkedList<>();
        pq.offer(new Tuple(0, src, 0));
        price[src] = 0;

        while (!pq.isEmpty()) {
            Tuple curr = pq.poll();
            int cost = curr.price;
            int u = curr.node;
            int stops = curr.stops;

            for (Pair neighbour : adj.get(u)) {
                int v = neighbour.node;
                int flightPrice = neighbour.price;

                // flights[(u, v, price)] => [[0,1,1], [1,2,1], [0,2,5], [2,3,1]]
                // this example explains why we considered cost instead of price[u]
                if (cost + flightPrice < price[v] && stops <= k) {
                    price[v] = cost + flightPrice;
                    pq.offer(new Tuple(price[v], v, stops + 1));
                }
            }
        }
        return price[dst] != Integer.MAX_VALUE ? price[dst] : -1;
    }
}
