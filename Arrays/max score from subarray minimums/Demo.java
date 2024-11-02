import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    
    public static int maxSubarrayMin(int[] arr) {
        int res = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; ++i) {
            res = Math.max(res, arr[i-1] + arr[i]);
        }
        return res;
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
        
        output.write(Integer.toString(maxSubarrayMin(arr)) + " ");

        input.close();
        output.close();
        
    }
}
