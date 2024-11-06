import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static int[] nextSmallerElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for(int i = n-1; i >= 0; --i) {
            while(top != -1 && nums[stack[top]] >= nums[i])
                --top;
            
            if(top == -1) res[i] = n - i;
            else res[i] = stack[top] - i;

            stack[++top] = i;
        }
        return res;
    }

    public static int[] prevSmallerOrEqualElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for(int i = 0; i < n; ++i) {
            while(top != -1 && nums[stack[top]] > nums[i])
                --top;
            
            if(top == -1) res[i] = i + 1;
            else res[i] = i - stack[top];

            stack[++top] = i;
        }
        return res;
    }
    public static int sumSubarrayMins(int[] nums) {
        int MOD = 1000_000_007;
        long sum = 0;

        int[] NSE = nextSmallerElement(nums);
        int[] PSE = prevSmallerOrEqualElement(nums);

        for(int i = 0; i < nums.length; ++i) {
            sum = (sum + (long)nums[i] * NSE[i] * PSE[i]) % MOD;
        }

        return (int) sum;
    }

    // public int sumSubarrayMins(int[] arr) {
    //     int len = arr.length;
    //     long sum = 0; 
    //     int mod = 1_000_000_007; 
    //     int[] left = new int[len];
    //     int[] right = new int[len];
        
    //     for (int i = 0; i <len;i++)
    //     {
    //         int count = 1;
    //         while (i - count >= 0 && arr[i - count] > arr[i]) {
    //             // reuse the arr[i - count]'s work i.e. If arr[i -
    //             // count] is greater than arr[i], then every element it could cover (stored in
    //             // left[i - count]) can also be covered by arr[i].
    //             count += left[i - count];
    //         }
    //         left[i] = count;
    //     }

    //     // Calculate right limits
    //     for (int i = len - 1; i >= 0; i--) {
    //         int count = 1;
    //         while (i + count < len && arr[i + count] >= arr[i]) {
    //             count += right[i + count];
    //         }
    //         right[i] = count;
    //     }

    //     // Calculate the sum of subarray minimums
    //     for (int i = 0; i < len; i++) {
    //         sum = (sum + (long) arr[i] * left[i] * right[i]) % mod;
    //     }
        
    //     return (int) sum;
    // }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();
        
        int res = sumSubarrayMins(nums);

        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}