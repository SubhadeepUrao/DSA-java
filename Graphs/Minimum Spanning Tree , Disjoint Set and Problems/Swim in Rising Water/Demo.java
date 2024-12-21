import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int elevation, i, j;
    Node(int elevation, int i, int j) {
        this.elevation = elevation;
        this.i = i;
        this.j = j;
    }
    public int compareTo(Node that) {
        return this.elevation - that.elevation;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][] dir = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
        boolean[][] visited = new boolean[N][N];
        int time = 0;
        
        pq.offer(new Node(grid[0][0], 0, 0));
        visited[0][0] = true;
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int elevation = curr.elevation;
            int x = curr.i;
            int y = curr.j;
            time = Math.max(time, elevation);

            for(int[] move : dir) {
                int i = x + move[0];
                int j = y + move[1];

                if(i < 0 || j < 0 || i == N || j == N || visited[i][j]) continue;

                if(i == N-1 && i == j) return Math.max(time, grid[i][j]);

                pq.offer(new Node(grid[i][j], i, j));
            }

            visited[x][y] = true;
        }
        return 0;
    }
}