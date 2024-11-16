import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Demo {
    static class Pair<K,V> {
        K first;
        V second;
        Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }
    public static int leastInterval(char[] tasks, int n) {
        int N = tasks.length;

        int[] freq = new int[26];
        for(int i = 0; i < N; ++i)
            ++freq[tasks[i] - 65];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < 26; ++i)
            pq.add(freq[i]);
        
        LinkedList<Pair<Integer, Integer>> q = new LinkedList<>(); // Queue
        int time = 0;
        while(N > 0) {
            ++time;
            
            if(pq.peek() != null && pq.peek() != 0) {
                int root = pq.remove();
                q.add(new Pair<>(--root, time + n));
                --N;
            }
            if(q.peek().second == time) {
                pq.add(q.remove().first);
            }
        }

        return time;
    }
    

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();

        char[] tasks = new char[N];
        for(int i = 0; i < N; ++i)
            tasks[i] = input.next().charAt(0);

        int k = input.nextInt(); // cooldown period
        
        int res = leastInterval(tasks, k);
        
        output.write(Integer.toString(res));
        
        input.close();
        output.close();
    }
}