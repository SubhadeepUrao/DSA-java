class Solution {
    static void dfs(int[][] isConnected, boolean[] visited, int node) {
        visited[node] = true;
        int V = visited.length;
        for(int neighbour = 0; neighbour < V; ++neighbour) {
            if(!visited[neighbour] && isConnected[node][neighbour] == 1)
                dfs(isConnected, visited, neighbour);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int V = isConnected.length;
        boolean[] visited = new boolean[V];

        for(int node = 0; node < V; ++node) {
            if(!visited[node]) {
                provinces++;
                dfs(isConnected, visited, node);
            }
        }
        return provinces;
    }
}