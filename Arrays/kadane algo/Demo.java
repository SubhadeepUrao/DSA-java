// KADANE's ALGORITHM

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
 
public class Demo {
    public static long maxSubarraySum(int[] arr) {
        long sum = 0;
        long maxSum = Long.MIN_VALUE;
        int start = 0, starti, endi = starti = 0;
        for(int i = 0; i < arr.length; ++i) {
            if(sum == 0) start = i;

            sum += arr[i];
            if(maxSum < sum) {
                maxSum = sum;
                starti = start;
                endi = i;
            }
            if(sum < 0) sum = 0;
        }
        if(maxSum < 0) { // sum of empty array is included
            maxSum = 0;
            starti = endi = -1;
        }
        System.out.println("[" + starti + "..." + endi + "]");
        return maxSum;
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        
        output.write(Long.toString(maxSubarraySum(arr)) + " ");

        input.close();
        output.close();
        
    }
}
