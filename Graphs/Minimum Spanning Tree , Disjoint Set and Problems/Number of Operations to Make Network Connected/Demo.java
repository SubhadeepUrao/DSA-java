class DisjointSet {
    int[] size;
    int[] parent;

    DisjointSet(int N) {
        size = new int[N];
        parent = new int[N];
        for(int i = 0; i < N; ++i) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    int find(int i) {
        if(parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int X, int Y) {
        int repX = find(X);
        int repY = find(Y);

        if(repX == repY) return;

        if(size[repX] < size[repY]) {
            parent[repX] = repY;
            size[repY] += size[repX];
        }
        else if(size[repX] >= size[repY]) {
            parent[repY] = repX;
            size[repX] += size[repY];
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;

        DisjointSet ds = new DisjointSet(n);
        int components = n;
        // int connectedCables = 0;

        for(int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];

            if(ds.find(u) != ds.find(v)) {
                ds.union(u, v);
                --components;
                // ++connectedCables;
            }
        }
        return components - 1;
        // return n - 1 - connectedCables;
    }
}