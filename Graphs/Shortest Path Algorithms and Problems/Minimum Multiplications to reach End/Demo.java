import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Pair {
        int node, steps;
        Pair(int node, int steps) {
            this.node = node;
            this.steps = steps;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) return 0;
        
        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int u = curr.node;
            int steps = curr.steps;
            
            for(int num : arr) {
                int v = u * num % 100000;
                if(v == end) return steps + 1;  
                if(steps + 1 < dist[v]) {
                    dist[v] = steps + 1;
                    q.offer(new Pair(v, dist[v]));
                }
            }
        }
        return -1;
    }
}