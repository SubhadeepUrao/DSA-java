import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static boolean gen(int i, int n, int sum, int target, int[] arr) {
        if(sum > target || i == n) return false;

        sum += arr[i];
        if(sum == target) return true;
        if(gen(i+1, n, sum, target, arr)) return true;
        sum -= arr[i];
        return gen(i+1, n, sum, target, arr);
    }
    public static boolean isSubsetPresent(int n, int target,int []arr) {
        return gen(0, n, 0, target, arr);
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

        boolean res = isSubsetPresent(n, target, arr);

        output.write(res + " ");

        input.close();
        output.close();
        
    }
}
