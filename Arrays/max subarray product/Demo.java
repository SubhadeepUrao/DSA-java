import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static int maxProduct(int[] arr) {
        int maxProd = Integer.MIN_VALUE;
        int n = arr.length;
        int prefix = 1;
        int suffix = 1;

        for(int i = 0; i < n; ++i) {

            prefix *= arr[i];
            suffix *= arr[n-1-i];

            maxProd = Math.max(maxProd, Math.max(prefix, suffix));
            
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
        }
        return maxProd;
    }
    
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        FileWriter output = new FileWriter("output.txt");


        int n = input.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; ++i) {
            arr[i] = input.nextInt();
        }

        int inv = maxProduct(arr);

        output.write(Integer.toString(inv));
        

        input.close();
        output.close();
    }
}