import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int missingNum(int[] arr, int N) {
        int sum = (N*N + N) / 2;
        int arraysum = 0;
        for(int i = 0; i < arr.length; ++i) {
            arraysum += arr[i]; 
        }
        return sum - arraysum;
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        int[] arr = new int[n-1];
        for(int i = 0; i < n-1; i++) {
            arr[i] = input.nextInt();
        }
        
        output.write(Integer.toString(missingNum(arr, n)));

        input.close();
        output.close();
        
    }
}
