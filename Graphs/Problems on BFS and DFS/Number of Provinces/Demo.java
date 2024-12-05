import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    static List<Integer> getComponent(int[][] isConnected, boolean[] visited, int currNode) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> component = new ArrayList<>();

        q.offer(currNode);
        visited[currNode] = true;
        while(!q.isEmpty()) {
            int node = q.poll();
            component.add(node);
            int V = isConnected.length;
            for(int neighbour = 0; neighbour < V; ++neighbour) {
                if(!visited[neighbour] && isConnected[node][neighbour] == 1) {
                    q.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return component;
    }
    static int countConnectedComponents(int[][] isConnected) {
        List<List<Integer>> components = new ArrayList<>();
        int V = isConnected.length;
        boolean[] visited = new boolean[V];

        for(int currNode = 0; currNode < V; ++currNode) {
            if(!visited[currNode]) {
                components.add(getComponent(isConnected, visited, currNode));
            }
        }
        return components.size();
    }
    public int findCircleNum(int[][] isConnected) {
        return countConnectedComponents(isConnected);
    }
}