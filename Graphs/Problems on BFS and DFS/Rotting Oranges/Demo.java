import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int freshOrange, M, N;
    Queue<int[]> q;

    void addAdjacentFreshOrange(int[] rotOrange, int[][] grid) {
        int i = rotOrange[0];
        int j = rotOrange[1];
        int[][] moves = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

        for (int[] move : moves) {
            int x = move[0] + i;
            int y = move[1] + j;
            if ((0 <= x && x < M) && (0 <= y && y < N) && grid[x][y] == 1) {
                q.offer(new int[] { x, y });
                grid[x][y] = 2;
                --freshOrange;
            }
        }
    }

    public int orangesRotting(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        q = new LinkedList<>();

        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (grid[i][j] == 1)
                    ++freshOrange;
                else if (grid[i][j] == 2)
                    q.offer(new int[] { i, j });
            }
        }

        if (freshOrange == 0) return 0; // no fresh oranges

        int time = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] rotOrange = q.poll();
                addAdjacentFreshOrange(rotOrange, grid);
            }
            ++time;
        }

        return freshOrange == 0 ? time : -1;
    }
}