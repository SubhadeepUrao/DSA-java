// Left Rotate by k elements

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
    public static void rotate(int[] arr, int k) {
        if(arr.length == k || arr.length == 1) return;

        if(arr.length < k) {
            int init = 0;
            int pos = 0;
            do {
                pos = (pos + k) % arr.length;
                swap(arr, 0, pos);
            } while(init != pos);
            return;
        }

        int[] temp = new int[k];
        for(int i = 0; i < k; ++i) {
            temp[i] = arr[arr.length - k + i];
        }
        for(int i = arr.length-1; i >= k; --i) {
            arr[i] = arr[i - k];
        }
        for(int i = 0; i < k; ++i) {
            arr[i] = temp[i];
        }
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
