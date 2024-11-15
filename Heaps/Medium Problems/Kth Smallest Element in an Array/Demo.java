import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Demo {
    
    public static int kthSmallestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        int n = nums.length;
        int i = 0;

        for(; i < k; ++i)
            pq.add(nums[i]);
        
        for(; i < n; ++i)
            if(nums[i] < pq.peek()) {
                pq.remove();
                pq.add(nums[i]);
            }
        
        return pq.peek();
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int K = input.nextInt();

        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();
        
        int res = kthSmallestElement(nums, K);
        
        output.write(Integer.toString(res));
        
        input.close();
        output.close();
    }
}