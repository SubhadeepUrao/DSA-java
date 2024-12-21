class Solution {
    static int islands;
    static class Node {
        Node parent;
        int size;
        Node() { size = 1; }
    }
    static Node find(Node node) {
        if(node.parent == null) return node;
        return node.parent = find(node.parent);
    }
    static boolean union(Node X, Node Y) {
        Node repX = find(X);
        Node repY = find(Y);

        if(repX == repY) return false;

        if(repX.size >= repY.size) {
            repY.parent = repX;
            repX.size += repY.size;
        }
        else {
            repX.parent = repY;
            repY.size += repX.size;
        }
        return true;
    }
    static int updateIslands(Node[][] grid, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] direction = {{0,-1},{-1,0},{0,1},{1,0}};

        Node curr = grid[x][y] = new Node();
        ++islands; // possibly new island created so we update

        for(int[] move : direction) {
            int i = x + move[0];
            int j = y + move[1];

            if(i < 0 || j < 0 || i == n || j == m) continue;

            if(grid[i][j] != null && union(grid[i][j], curr))
                --islands; // union successful concludes islands should be decremented by 1
        }
        return islands;
    }
    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        Node[][] grid = new Node[n][m];
        int[] res = new int[q.length];
        islands = 0;

        // int maxClusters = (n+1)/2 * (m+1)/2;
        // PriorityQueue<Integer> pq = new PriorityQueue<>(); // cluster index pool
        // IntStream.range(0, maxClusters).forEach(pq::add);

        for(int i = 0; i < q.length; ++i) {
            res[i] = updateIslands(grid, q[i][0], q[i][1]);
        }

        return res;
    }
}