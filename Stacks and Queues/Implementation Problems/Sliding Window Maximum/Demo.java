import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];

        for(int i = 0; i < n; ++i) {
            while(!deq.isEmpty() && deq.peekLast() < nums[i])
                deq.removeLast();
            deq.addLast(nums[i]);
            if(i >= k && deq.peekFirst() == nums[i-k])
                deq.removeFirst();
            if(i >= k-1)
                res[i-k+1] = deq.peekFirst();
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int k = input.nextInt();

        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();
        
        int[] res = maxSlidingWindow(nums, k);
        output.write(Arrays.toString(res));

        input.close();
        output.close();
    }
}