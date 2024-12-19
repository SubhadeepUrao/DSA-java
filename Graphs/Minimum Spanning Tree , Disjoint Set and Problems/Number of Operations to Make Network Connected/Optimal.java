class Solution {
    int[] rank;
    int[] parent;

    int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }

    int union(int X, int Y) {
        int repX = find(X);
        int repY = find(Y);

        if (repX == repY) return 0;

        if (rank[repX] < rank[repY])
            parent[repX] = repY;
        else if (rank[repX] > rank[repY])
            parent[repY] = repX;
        else {
            parent[repY] = repX;
            ++rank[repX];
        }
        return 1;
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; ++i)
            parent[i] = i;

        int components = n;

        for (int[] edge : connections) {
            components -= union(edge[0], edge[1]);
        }
        return components - 1;
    }
}