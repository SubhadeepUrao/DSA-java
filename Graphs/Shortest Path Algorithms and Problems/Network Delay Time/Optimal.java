import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Pair {
        int time, node;
        Pair(int node, int time) {
            this.node= node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; ++i)
            adj.add(new ArrayList<>());
        for(int[] info : times)
            adj.get(info[0]).add(new Pair(info[1], info[2]));
        
        int[] delay = new int[n+1];
        Arrays.fill(delay, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(k, 0));
        delay[k] = 0;

        while(!q.isEmpty()) {
            int u = q.peek().node;
            
            if(q.poll().time > delay[u]) continue; // handle outdated pair

            for(Pair neighbour : adj.get(u)) {
                int v = neighbour.node;
                int time = neighbour.time;
                if(delay[u] + time < delay[v]) {
                    delay[v] = delay[u] + time;
                    q.offer(new Pair(v, delay[v]));
                }
            }
        }
        int maxi = 0;
        for(int i = 1; i <= n; ++i) {
            if(delay[i] == Integer.MAX_VALUE) return -1;
            maxi = Math.max(maxi, delay[i]);
        }
        return maxi;
    }
}