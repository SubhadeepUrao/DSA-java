class Solution {
    int M, N;

    void infect(char[][] board, boolean[][] visited, int i, int j) {
        visited[i][j] = true;

        int[][] moves = {{-1,0}, {0,-1}, {0,1},{1,0}};

        for(int[] move : moves) {
            int x = move[0] + i;
            int y = move[1] + j;
            if((0 <= x && x < M) && (0 <= y && y < N) && !visited[x][y] && board[x][y] == 'O') 
                infect(board, visited, x, y);
        }
    }

    public void solve(char[][] board) {
        M = board.length;
        N = board[0].length;
        boolean[][] visited = new boolean[M][N];

        int lastCol = N-1;
        int lastRow = M-1;
        for(int i = 0; i < N; ++i) {
            if(!visited[0][i] && board[0][i] == 'O') infect(board, visited, 0, i);
            if(!visited[lastRow][i] && board[lastRow][i] == 'O') infect(board, visited, lastRow, i);
        }
        for(int i = 1; i < lastRow; ++i) {
            if(!visited[i][0] && board[i][0] == 'O') infect(board, visited, i, 0);
            if(!visited[i][lastCol] && board[i][lastCol] == 'O') infect(board, visited, i, lastCol);
        }

        for(int i = 0; i < M; ++i)
            for(int j = 0; j < N; ++j)
                if(!visited[i][j])
                    board[i][j] = 'X';
    }
}