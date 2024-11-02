import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal {
    public static void sort012(int[] arr) {
        int zero, one = zero = one = 0;
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] == 0) ++zero;
            else if(arr[i] == 1) ++one;
        }
        for(int i = 0; i < arr.length; ++i) {
            if(0 < zero) {
                arr[i] = 0;
                --zero;
            }
            else if(0 < one) {
                arr[i] = 1;
                --one;
            }
            else {
                arr[i] = 2;
            }
        }
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
        
        sort012(arr);
        for(int elem : arr) {
            output.write(Integer.toString(elem) + " ");
        }

        input.close();
        output.close();
        
    }
}
