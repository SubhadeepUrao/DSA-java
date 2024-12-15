import java.util.Arrays;
import java.util.PriorityQueue;

class Triplet {
    int dist, i, j;
    Triplet(int dist, int i, int j) {
        this.dist = dist;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;

        // Edge case: start or end blocked
        if (grid[0][0] == 1 || grid[N-1][M-1] == 1) {
            return -1;
        }

        int[][] dist = new int[N][M];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.offer(new Triplet(1, 0, 0));
        dist[0][0] = 1;

        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        while (!pq.isEmpty()) {
            Triplet current = pq.poll();
            int currDist = current.dist;
            int currI = current.i;
            int currJ = current.j;

            // If we reached the destination
            if (currI == N - 1 && currJ == M - 1) {
                return currDist;
            }

            for (int[] dir : directions) {
                int i = currI + dir[0];
                int j = currJ + dir[1];

                if (i < 0 || j < 0 || i >= N || j >= M || grid[i][j] == 1) {
                    continue;
                }

                if (currDist + 1 < dist[i][j]) {
                    dist[i][j] = currDist + 1;
                    pq.offer(new Triplet(dist[i][j], i, j));
                }
            }
        }

        return -1;
    }
}
