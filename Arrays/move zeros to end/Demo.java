import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void shiftZeroEnd(int[] arr) {
        int zero_pos = 0;
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] != 0) {
                swap(arr, zero_pos, i);
                zero_pos++;
            }
        }
    }
    public static void print(int[] arr, FileWriter output) throws IOException {
        for(int i = 0; i < arr.length; ++i) {
            output.write(Integer.toString(arr[i]) + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int size = 0;
        while(input.hasNextInt()) {
            input.next();
            size++;
        }
        input.close();
        input = new Scanner(inputfile);

        int[] arr = new int[size];
        int i = 0;
        while(input.hasNextInt()) {
            arr[i] = input.nextInt();
            i++;
        }

        shiftZeroEnd(arr);

        print(arr, output);

        input.close();
        output.close();
        
    }

}
