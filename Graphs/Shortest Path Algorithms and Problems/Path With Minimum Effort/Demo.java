import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    class Tuple implements Comparable<Tuple> {
        int effort, i, j;

        Tuple(int effort, int i, int j) {
            this.effort = effort;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.effort - that.effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int N = heights.length;
        int M = heights[0].length;

        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int[][] effort = new int[N][M];
        for (int[] rows : effort)
            Arrays.fill(rows, Integer.MAX_VALUE);

        pq.offer(new Tuple(0, 0, 0));
        effort[0][0] = 0;

        int[][] direction = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

        while (!pq.isEmpty()) {
            Tuple tuple = pq.poll();
            int currEffort = tuple.effort;
            int curr_i = tuple.i;
            int curr_j = tuple.j;

            if( curr_i == N-1 && curr_j == M-1)
                return currEffort;

            for (int[] moves : direction) {
                int i = moves[0] + curr_i;
                int j = moves[1] + curr_j;

                if (i < 0 || j < 0 || i == N || j == M)
                    continue;

                int diff = Math.max(currEffort, Math.abs(heights[i][j] - heights[curr_i][curr_j]));

                if (diff < effort[i][j]) {
                    effort[i][j] = diff;
                    pq.offer(new Tuple(diff, i, j));
                }
            }
        }
        return 0;
    }
}