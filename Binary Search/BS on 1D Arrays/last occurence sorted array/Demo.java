import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    
    public static int lastOccurence(int[] arr, int x) {
        int lb = 0;
        int ub = arr.length - 1;
        int mid;
        int ans = -1;

        while(lb <= ub) {
            mid = (lb + ub) / 2;
            if(x == arr[mid]) {
                ans = mid;
                lb = mid + 1;
            }
            else if(x < arr[mid]) ub = mid - 1;
            else lb = mid + 1;
        }
        return ans;
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

        int res = lastOccurence(arr, x);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
