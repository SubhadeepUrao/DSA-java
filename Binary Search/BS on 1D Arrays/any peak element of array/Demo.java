import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    
    public static int findPeakElement(int[] arr) {
        int n = arr.length;

        if(n == 1) return 0;
        if(arr[0] > arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;

        int lb = 1;
        int ub = n-2;
        int mid;

        while(lb <= ub) {
            mid = (lb + ub) / 2;
            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) return mid;
            if(arr[mid-1] < arr[mid]) lb = mid + 1;
            else ub = mid - 1;
        }
        return -1;
    }
    
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int size = input.nextInt();
        // int x = input.nextInt();
        
        int[] arr = new int[size];
        for(int i = 0; i < size; ++i) {
            arr[i] = input.nextInt();
        }

        int res = findPeakElement(arr);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
