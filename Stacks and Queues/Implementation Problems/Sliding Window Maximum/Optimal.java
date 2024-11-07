import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Optimal {

    // deque stores indices
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int[] deq = new int[n];
        int top = -1;
        int front = 0;

        for (int i = 0; i < n; ++i) {
            while (top >= front && nums[deq[top]] < nums[i])
                --top;
            deq[++top] = i;

            if (i - k == deq[front])
                ++front;
            if (i >= k - 1)
                res[i - k + 1] = nums[deq[front]];
        }
        return res;
    }

    // // deque stores values
    // public static int[] maxSlidingWindow(int[] nums, int k) {
    //     int n = nums.length;
    //     int[] res = new int[n-k+1];
    //     int[] deq = new int[n];
    //     int top = -1;
    //     int front = 0;

    //     for(int i = 0; i < n; ++i) {
    //         while(top >= front && deq[top] < nums[i])
    //             --top;
    //         deq[++top] = nums[i];

    //         if(i >= k && deq[front] == nums[i-k])
    //             ++front;
    //         if(i >= k-1)
    //             res[i-k+1] = deq[front];
    //     }
    //     return res;
    // }
    
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