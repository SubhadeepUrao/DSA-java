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
    public static void sort012(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        for(int i = 0; i <= right; ++i) {
            if(arr[i] == 0) {
                swap(arr, left, i);
                left++;
            }
            else if(arr[i] == 2) {
                swap(arr, right, i);
                right--;
            }
            else continue;
            if(arr[i] == 0 && left < i) --i;
            else if(arr[i] == 2 && i < right) --i;
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
