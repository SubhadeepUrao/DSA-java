import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Demo {
    public static long connectRopes(int[] arr) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        int N = arr.length;
        for(int i = 0; i < N; ++i)
            pq.add((long)arr[i]);
        
            long total = 0;
        while(N > 1) {
            long a = pq.remove();
            long b = pq.remove();
            long sum = a + b;
            pq.add(sum);
            total += sum;
            --N;
        }
        return total;
    }
    
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();

        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();
        
        long res = connectRopes(nums);
        
        output.write(Long.toString(res));
        
        input.close();
        output.close();
    }
}