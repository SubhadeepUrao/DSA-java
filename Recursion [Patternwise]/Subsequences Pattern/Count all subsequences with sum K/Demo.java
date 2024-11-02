import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    // take , not take
    // public static int gen(int[] arr, int i, int n, int sum, int target) {
    //     if(sum > target) return 0;
    //     if(i == n) {
    //         if(sum == target) return 1;
    //         return 0;
    //     }
    //     int count = gen(arr, i+1, n, sum+arr[i], target);
    //     count += gen(arr, i+1, n, sum, target);
    //     return count % 1000_000_007;
    // }
    
    public static int gen(int[] arr, int i, int n, int sum, int target) {
        if(sum > target || i == n) return 0;
        int count = 0;
        while(i < n) {
            sum += arr[i];
            if(sum == target) ++count;
            count += gen(arr, i+1, n, sum, target);
            sum -= arr[i];
            ++i;
        }
        return count % 1000_000_007;
    }

    public static int perfectSum(int arr[],int n, int target) {
        // return gen(arr, 0, n, 0, target);
	    return gen(arr, 0, n, 0, target);
    }

    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int target = input.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; ++i)
            arr[i] = input.nextInt();

        int res = perfectSum(arr, n, target);

        output.write(res + " ");

        input.close();
        output.close();
        
    }
}
