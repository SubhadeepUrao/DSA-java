import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal {
    public static int leastInterval(char[] tasks, int n) {
        int N = tasks.length;

        int[] freq = new int[26];
        for(int i = 0; i < N; ++i)
            ++freq[tasks[i] - 65];

        int maxf = 0;
        for(int i = 0; i < 26; ++i)
            maxf = Math.max(maxf, freq[i]);
            
        int maxf_elem = 0;
        for(int i = 0; i < 26; ++i)
            if(freq[i] == maxf) ++maxf_elem;
        
        int gaps_between_maxf = maxf - 1; // A _ _ _ A _ _ _ A => 2 gaps
        int rem_gaps = n - (maxf_elem - 1); // A B _ _ A B _ _ A => 2 remaining gaps after filing maxf

        int rem_slots = gaps_between_maxf * rem_gaps;
        int rem_tasks = N - maxf * maxf_elem;

        int idle = Math.max(0, rem_slots - rem_tasks);

        return N + idle;
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