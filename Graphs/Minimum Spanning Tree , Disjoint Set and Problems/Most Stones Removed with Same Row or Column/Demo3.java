import java.util.HashSet;
import java.util.Set;

class DisjoinSet {
    int[] rank;
    int[] parent;

    DisjoinSet(int N) {
        rank = new int[N];
        parent = new int[N];
        for(int i = 0; i < N; ++i)
            parent[i] = i;
    }

    int find(int i) { // also path compresses
        if(parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    void union(int X, int Y) {
        int repOfX = find(X); // representative of set X
        int repOfY = find(Y); // representative of set Y

        if(repOfX == repOfY) return; // part of the same set

        if(rank[repOfX] < rank[repOfY])
            parent[repOfX] = repOfY;
        else if(rank[repOfX] > rank[repOfY])
            parent[repOfY] = repOfX;
        else {
            parent[repOfY] = repOfX;
            ++rank[repOfX];
        }
    }
}

class Solution {
    
    // max #removable_stones from k-component graph
    // = (x1-1) + (x2-1) + ... + (xk - 1) 
    // = (x1+x2+...+xk) - k 
    // = #stones - k

    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for(int i = 0; i < stones.length; ++i) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        
        DisjoinSet ds = new DisjoinSet(maxRow + maxCol + 2);
        Set<Integer> unique = new HashSet<>(); // to find only the components that exists
        for(int[] stone : stones) {
            int i = stone[0];
            int j = stone[1] + maxRow + 1;

            ds.union(i, j);
            unique.add(i);
            unique.add(j);
        }

        int components = 0;
        for(int key : unique) {
            if(ds.find(key) == key) ++components;
        }
        return stones.length - components;
    }
}