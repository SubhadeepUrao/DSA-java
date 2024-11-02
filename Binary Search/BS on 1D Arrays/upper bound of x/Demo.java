import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int upperBound(int []arr, int x, int n){
        int mid;
        int lb = 0;
        int ub = n-1;
        while(lb <= ub) {
            mid = (lb + ub) / 2;
            if(x < arr[mid]) ub = mid - 1;
            else lb = mid + 1;
        }
        return lb;
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int size = input.nextInt();
        int x = input.nextInt();
        
        int[] arr = new int[size];
        for(int i = 0; i < size; ++i) {
            arr[i] = input.nextInt();
        }

        output.write(Integer.toString(upperBound(arr, x, size)));

        input.close();
        output.close();
        
    }
}
