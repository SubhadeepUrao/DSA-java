import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Demo {
    
    public static int kthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;

        for(int i = 0; i < k; ++i)
            pq.add(nums[i]);

        // minheap contains k largest elements among the elements seen so far
        // and will also contain k largest elements on seeing elements ahead

        for(int i = k; i < n; ++i)
            if(nums[i] > pq.peek()) {
                pq.remove();
                pq.add(nums[i]);
            }
        
        return pq.peek();
    }

    // public static int kthLargestElement(int[] nums, int k) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));

    //     for(int elem : nums)
    //         pq.add(elem);

    //     for(int i = 1; i < k; ++i)
    //         pq.remove();
        
    //     return pq.peek();
    // }

    // public static int kthLargestElement(int[] nums, int k) {
    //     PriorityQueue<Integer> pq = new PriorityQueue<>();

    //     for(int elem : nums)
    //         pq.add(elem);

    //     int n = nums.length - k;
    //     for(int i = 0; i < n; ++i)
    //         pq.remove();
        
    //     return pq.peek();
    // }
    
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int K = input.nextInt();

        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();
        
        int res = kthLargestElement(nums, K);
        
        output.write(Integer.toString(res));
        
        input.close();
        output.close();
    }
}