class Solution {
    boolean dfs(int[][] graph, int node, boolean[] A, boolean[] B) {
        if(!A[node] && !B[node])
            A[node] = true;

        for(int neighbour : graph[node]) {
            if(A[neighbour]) return false;
            if(!B[neighbour] && !dfs(graph, neighbour, B, A)) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        boolean[] A = new boolean[graph.length];
        boolean[] B = new boolean[graph.length];

        for(int node = 0; node < graph.length; ++node) {
            if(!A[node] && !B[node] && !dfs(graph, node, A, B)) return false;
        }
        return true;
    }
}