class Solution {
    int M, N;

    void infect(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') return;

        // Mark this 'O' as Immune (i.e., not surrounded) by marking it as 'S'
        // alternative for visited array
        board[i][j] = 'I';

        // Visit all 4 neighboring cells
        infect(board, i - 1, j); // Up
        infect(board, i + 1, j); // Down
        infect(board, i, j - 1); // Left
        infect(board, i, j + 1); // Right
    }

    void swap(char[][] board, char src, char target) {
        for(int i = 0; i < M; ++i)
            for(int j = 0; j < N; ++j)
                if(board[i][j] == src)
                    board[i][j] = target;
    }

    public void solve(char[][] board) {
        M = board.length;
        N = board[0].length;

        int lastCol = N-1;
        int lastRow = M-1;
        for(int i = 0; i < N; ++i) {
            if(board[0][i] == 'O') infect(board, 0, i);
            if(board[lastRow][i] == 'O') infect(board, lastRow, i);
        }
        for(int i = 1; i < lastRow; ++i) {
            if(board[i][0] == 'O') infect(board, i, 0);
            if(board[i][lastCol] == 'O') infect(board, i, lastCol);
        }

        swap(board, 'O', 'X');
        swap(board, 'I', 'O');
    }
}