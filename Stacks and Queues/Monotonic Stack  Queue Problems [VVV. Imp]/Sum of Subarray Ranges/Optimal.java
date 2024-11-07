import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal {
    public static long sumSubarrayMins(int[] arr) {
        int len = arr.length;
        long sum = 0; 
        int[] left = new int[len];
        int[] right = new int[len];
        
        // Calculate left limits
        for (int i = 0; i <len;i++)
        {
            int count = 1;
            while (i - count >= 0 && arr[i - count] > arr[i]) {
                // reuse the arr[i - count]'s work i.e. If arr[i -
                // count] is greater than arr[i], then every element it could cover (stored in
                // left[i - count]) can also be covered by arr[i].
                count += left[i - count];
            }
            left[i] = count;
        }

        // Calculate right limits
        for (int i = len - 1; i >= 0; i--) {
            int count = 1;
            while (i + count < len && arr[i + count] >= arr[i]) {
                count += right[i + count];
            }
            right[i] = count;
        }

        // Calculate the sum of subarray minimums
        for (int i = 0; i < len; i++) {
            sum += (long) arr[i] * left[i] * right[i];
        }
        
        return sum;
    }

    public static long sumSubarrayMaxs(int[] arr) {
        int len = arr.length;
        long sum = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        
        for (int i = 0; i <len;i++)
        {
            int count = 1;
            while (i - count >= 0 && arr[i - count] < arr[i]) {
                // reuse the arr[i - count]'s work i.e. If arr[i -
                // count] is greater than arr[i], then every element it could cover (stored in
                // left[i - count]) can also be covered by arr[i].
                count += left[i - count];
            }
            left[i] = count;
        }

        // Calculate right limits
        for (int i = len - 1; i >= 0; i--) {
            int count = 1;
            while (i + count < len && arr[i + count] <= arr[i]) {
                count += right[i + count];
            }
            right[i] = count;
        }

        // Calculate the sum of subarray minimums
        for (int i = 0; i < len; i++) {
            sum += (long) arr[i] * left[i] * right[i];
        }
        
        return sum;
    }

    public static long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();
        
        long res = subArrayRanges(nums);

        output.write(Long.toString(res));

        input.close();
        output.close();
    }
}
