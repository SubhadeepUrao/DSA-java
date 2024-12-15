import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;

        // Edge case: start or end blocked
        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1)
            return -1;
        if (N == 1)
            return 1;

        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[] { 1, 0, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currDist = current[0];
            int curr_i = current[1];
            int curr_j = current[2];

            for (int i = curr_i - 1; i <= curr_i + 1; ++i) {
                for (int j = curr_j - 1; j <= curr_j + 1; ++j) {

                    if (i < 0 || j < 0 || i == N || j == N || grid[i][j] == 1)
                        continue;

                    // If we reached the destination
                    if (i == N - 1 && j == N - 1) {
                        return currDist + 1;
                    } else {
                        pq.offer(new int[] { currDist + 1, i, j });
                        grid[i][j] = 1;
                    }
                }
            }
        }

        return -1;
    }
}