import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Pair {
        int timeSpent, intersection;
        Pair(int intersection, int timeSpent) {
            this.intersection = intersection;
            this.timeSpent = timeSpent;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());
        for(int[] info : roads) {
            adj.get(info[0]).add(new Pair(info[1], info[2]));
            adj.get(info[1]).add(new Pair(info[0], info[2]));
        }

        int[] delay = new int[n];
        Arrays.fill(delay, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        delay[0] = 0;
        int cnt = 0; // atleast a path exists

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int u = curr.intersection;
            int time = curr.timeSpent;

            if(time > delay[u]) continue;
            if(u == n-1) ++cnt;

            for(Pair neighbour : adj.get(u)) {
                int v = neighbour.intersection;
                int timeSpent = neighbour.timeSpent;
                if(delay[u] + timeSpent <= delay[v]) {
                    delay[v] = delay[u] + timeSpent;
                    q.offer(new Pair(v, delay[v]));
                }
            }
        }
        return cnt;
    }
}