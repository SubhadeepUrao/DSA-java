import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> points;
    boolean[] visited;
    int[] discoveryTime;
    int[] lowestTimeAccess;
    int timer = 0;

    void dfs(ArrayList<ArrayList<Integer>> adj, int node, int parent) {
        discoveryTime[node] = lowestTimeAccess[node] = ++timer;
        visited[node] = true;
        int children = 0;

        for (int neighbour : adj.get(node)) {
            if (neighbour == parent) continue;

            if (!visited[neighbour]) {
                children++;
                dfs(adj, neighbour, node);
                lowestTimeAccess[node] = Math.min(lowestTimeAccess[node], lowestTimeAccess[neighbour]);

                // Articulation point conditions
                if (parent == -1 && children > 1) {
                    points.add(node);  // Root is an articulation point if it has more than one child
                } else if (parent != -1 && lowestTimeAccess[neighbour] >= discoveryTime[node]) {
                    points.add(node);  // Non-root is an articulation point if the lowest reachable node
                    // is greater than or equal to the discovery time of the current node
                }
            } else {
                lowestTimeAccess[node] = Math.min(lowestTimeAccess[node], discoveryTime[neighbour]);
            }
        }
    }

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        if (V < 3) return new ArrayList<>(Arrays.asList(-1)); // No articulation points in graphs with fewer than 3 vertices
        
        points = new HashSet<>();
        visited = new boolean[V];
        discoveryTime = new int[V];
        lowestTimeAccess = new int[V];

        dfs(adj, 0, -1);

        // Sort and return the articulation points
        if (points.size() == 0) {
            return new ArrayList<>(Arrays.asList(-1));
        } else {
            ArrayList<Integer> res = new ArrayList<>(points);
            Collections.sort(res);
            return res;
        }
    }
}