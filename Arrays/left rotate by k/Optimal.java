import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal {

    public static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void rotate(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
    }
    public static void print(int[] arr, FileWriter output) throws IOException {
        for(int i = 0; i < arr.length; ++i) {
            output.write(String.valueOf(arr[i]) + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int size = -1;
        while(input.hasNextInt()) {
            input.next();
            size++;
        }
        input.close();
        input = new Scanner(inputfile);

        int[] arr = new int[size];
        int k = input.nextInt();
        int i = 0;
        while(input.hasNextInt()) {
            arr[i] = input.nextInt();
            i++;
        }

        rotate(arr, k);

        print(arr, output);

        input.close();
        output.close();
        
    }
}
