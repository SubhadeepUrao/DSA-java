import java.util.HashSet;

class Solution {
    int islands;
    class Node {
        Node parent;
        int size;
        Node() { size = 1; }
    }
    Node find(Node node) {
        if(node.parent == null) return node;
        return node.parent = find(node.parent);
    }
    boolean union(Node X, Node Y) {
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
    void updateIslands(Node[][] sea, int x, int y) {
        if(sea[x][y] != null) return;
        
        int n = sea.length;
        int m = sea[0].length;
        int[][] direction = {{0,-1},{-1,0},{0,1},{1,0}};

        Node curr = sea[x][y] = new Node();
        ++islands; // possibly new island created so we update

        for(int[] move : direction) {
            int i = x + move[0];
            int j = y + move[1];

            if(i < 0 || j < 0 || i == n || j == m) continue;

            if(sea[i][j] != null && union(sea[i][j], curr))
                --islands; // union successful concludes islands should be decremented by 1
        }
    }
    int findSizeIfIncluded(Node[][] sea, int x, int y) {
        int n = sea.length;
        int m = sea[0].length;
        int[][] direction = {{0,-1},{-1,0},{0,1},{1,0}};

        HashSet<Node> unique = new HashSet<>();
        int islandSize = 1;

        for(int[] move : direction) {
            int i = x + move[0];
            int j = y + move[1];

            if(i < 0 || j < 0 || i == n || j == m || sea[i][j] == null) continue;

            Node neighbourIsland = find(sea[i][j]);
            if(!unique.contains(neighbourIsland)) {
                islandSize += neighbourIsland.size;
                unique.add(neighbourIsland);
            }
        }
        return islandSize;
    }
    public int largestIsland(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        Node[][] sea = new Node[N][M];

        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < M; ++j) {
                if(grid[i][j] == 1) {
                    updateIslands(sea, i, j);
                }
            }
        }

        if(islands == 0) return 1;

        int largest = 0;
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < M; ++j) {
                if(grid[i][j] == 0) {
                    largest = Math.max(largest, findSizeIfIncluded(sea, i, j));
                }
            }
        }

        return largest > 0 ? largest : N*M;
    }
}