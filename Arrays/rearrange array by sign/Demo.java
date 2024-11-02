import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int[] rearrangeArray(int[] arr) {
        int pos = 0;
        int neg = 1;
        int res[] = new int[arr.length];
        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] < 0) {
                res[neg] = arr[i];
                neg += 2;
            }
            else {
                res[pos] = arr[i];
                pos += 2;
            }
        }
        return res;
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
        
        arr = rearrangeArray(arr);
        for(int elem : arr) {
            output.write(Integer.toString(elem) + " ");
        }

        input.close();
        output.close();
        
    }
}
