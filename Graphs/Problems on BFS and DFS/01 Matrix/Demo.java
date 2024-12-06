import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Info {
        int i;
        int j;
        int steps;
        Info(int i, int j, int steps) {
            this.i = i;
            this.j = j;
            this.steps = steps;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        int[][] dist = new int[M][N];
        boolean[][] visited = new boolean[M][N];
        Queue<Info> q = new LinkedList<>();

        for(int i = 0; i < M; ++i)
            for(int j = 0; j < N; ++j)
                if(mat[i][j] == 0) {
                    q.offer(new Info(i, j, 0));
                    visited[i][j] = true;
                }

        int[][] moves = {{0,-1}, {-1,0}, {0,1}, {1,0}};

        while(!q.isEmpty()) {
            Info info = q.poll();
            int i = info.i;
            int j = info.j;
            int steps = dist[i][j] = info.steps;
            for(int[] move : moves) {
                int x = move[0] + i;
                int y = move[1] + j;
                if((0 <= x && x < M) && (0 <= y && y < N) && !visited[x][y]) {
                    visited[x][y] = true;
                    q.offer(new Info(x, y, steps + 1));
                }
            }
        }

        return dist;
    }
}