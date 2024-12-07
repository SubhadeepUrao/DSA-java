import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Info {
        int i;
        int j;
        Info(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public void solve(char[][] board) {
        int M = board.length;
        int N = board[0].length;
        boolean[][] visited = new boolean[M][N];
        Queue<Info> q = new LinkedList<>();

        int lastCol = N-1;
        int lastRow = M-1;
        for(int i = 0; i < N; ++i) {
            if(!visited[0][i] && board[0][i] == 'O') {
                q.offer(new Info(0, i));
                visited[0][i] = true;
            }
            if(!visited[lastRow][i] && board[lastRow][i] == 'O') {
                q.offer(new Info(lastRow, i));
                visited[lastRow][i] = true;
            }
        }
        for(int i = 1; i < lastRow; ++i) {
            if(!visited[i][0] && board[i][0] == 'O') {
                q.offer(new Info(i, 0));
                visited[i][0] = true;
            }
            if(!visited[i][lastCol] && board[i][lastCol] == 'O') {
                q.offer(new Info(i, lastCol));
                visited[i][lastCol] = true;
            }
        }

        int[][] moves = {{-1,0}, {0,-1}, {0,1},{1,0}};
        while(!q.isEmpty()) {
            Info info = q.poll();
            int i = info.i;
            int j = info.j;

            for(int[] move : moves) {
                int x = move[0] + i;
                int y = move[1] + j;
                if((0 <= x && x < M) && (0 <= y && y < N) && !visited[x][y] && board[x][y] == 'O') {
                    visited[x][y] = true;
                    q.offer(new Info(x, y));
                }
            }
        }

        for(int i = 0; i < M; ++i)
            for(int j = 0; j < N; ++j)
                if(!visited[i][j])
                    board[i][j] = 'X';
    }
}