import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int find(int[] arr, int x, int lb, int ub) {
        if(lb <= ub) {
            int mid = (lb + ub) / 2;
            if(arr[mid] == x) return mid;
            else if(arr[mid] < x) return find(arr, x, mid+1, ub);
            else return find(arr, x, lb, mid-1);
        }
        return ub;
    }

    public static int floor(int[] arr, int x) {
        return x < arr[0] ? -1 : find(arr, x, 0, arr.length-1);
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
        output.write(Integer.toString(floor(arr, x)));

        input.close();
        output.close();
        
    }
}
