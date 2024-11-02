import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int find(int[] arr, int x, int lb, int ub) {
        while(lb <= ub) {
            int mid = (lb + ub) / 2;
            if(x <= arr[mid]) return find(arr, x, lb, mid-1);
            else return find(arr, x, mid+1, ub);
        }
        return lb;
    }

    public static int lowerBound(int[] arr, int x) {
        return find(arr, x, 0, arr.length-1);
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

        // System.out.println(size);
        output.write(Integer.toString(lowerBound(arr, x)));

        input.close();
        output.close();
        
    }
}
