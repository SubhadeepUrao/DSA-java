// remove duplicates from sorted array

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int removeDuplicates(int[] arr) {
        int left = 1;
        for(int i = 1; i < arr.length; ++i) {
            if(arr[i-1] != arr[i]) {
                arr[left++] = arr[i];
            }
        }
        return left;
    }

    public static void writeToFile(int[] arr, int n, FileWriter output) throws IOException {
        for(int i = 0; i < n; ++i) {
            output.write(String.valueOf(arr[i]) + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        // int[] arr = {2,2,2,3,3,4,4,6,6,7};
        Scanner input = new Scanner(new File("input.txt"));
        FileWriter output = new FileWriter("output.txt");

        int size = 0;
        while(input.hasNextInt()) {
            input.next();
            size++;
        }
        input.close();
        input = new Scanner(new File("input.txt"));
        int[] arr = new int[size];
        int i = 0;
        while(input.hasNextInt()) {
            arr[i] = input.nextInt();
            i++;
        }
        int left = removeDuplicates(arr);
        writeToFile(arr, left, output);

        input.close();
        output.close();
    }
}