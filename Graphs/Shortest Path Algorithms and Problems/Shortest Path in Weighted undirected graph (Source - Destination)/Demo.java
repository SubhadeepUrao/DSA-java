import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

class Pair {
    int dist, node;
    Pair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}
class Demo {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        if(m == 0) return new ArrayList<>();

        int src = 1;
        int destiny = n;
        List<List<Pair>> adj = new ArrayList<>();

        // create adjacency list
        for(int i = 0; i <= n; ++i)
            adj.add(new ArrayList<>());
        for(int e = 0; e < m; ++e) {
            adj.get(edges[e][0]).add(new Pair(edges[e][2], edges[e][1]));
            adj.get(edges[e][1]).add(new Pair(edges[e][2], edges[e][0]));
        }

        // (dist, vertex)
        TreeSet<Pair> st = new TreeSet<>((a, b) -> {
            if(a.dist != b.dist) return Integer.compare(a.dist, b.dist);
            return Integer.compare(a.node, b.node);
        });
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        st.add(new Pair(0, src));
        dist[src] = 0;
        int[] parent = new int[n+1];
        parent[src] = -1;

        while(!st.isEmpty()) {
            int u = st.pollFirst().node;

            for(Pair neighbour : adj.get(u)) {
                int v = neighbour.node;
                int weight = neighbour.dist;
                if(dist[u] + weight < dist[v]) {
                    st.remove(new Pair(dist[v], v));
                    dist[v] = dist[u] + weight;
                    st.add(new Pair(dist[v], v));
                    parent[v] = u;
                }
            }
        }

        if(dist[destiny] == Integer.MAX_VALUE) return new ArrayList<>();

        List<Integer> shortestPath = new LinkedList<>();
        shortestPath.add(destiny);
        int node = destiny;
        while(parent[node] != -1) {
            shortestPath.add(0, parent[node]);
            node = parent[node];
        }
        return shortestPath;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int m = input.nextInt();

        int[][] edges = new int[m][3];

        for(int e = 0; e < m; ++e) {
            int u = input.nextInt();
            int v = input.nextInt();
            int weight = input.nextInt();
            edges[e] = new int[]{u, v, weight};
        }

        List<Integer> path = shortestPath(n, m, edges);

        output.write(path.toString());

        input.close();
        output.close();
    }
}