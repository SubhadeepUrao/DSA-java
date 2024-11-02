import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int appearOnce(int[] arr, int N) {
        int val = 0;
        for(int i = 0; i < arr.length; ++i) {
            val ^= arr[i];
        }
        return val;
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
        
        output.write(Integer.toString(appearOnce(arr, n)));

        input.close();
        output.close();
        
    }
}
