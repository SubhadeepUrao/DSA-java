import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int findKthMissingElement(int[] arr, int n, int K) {
        int lb = 0;
        int ub = n - 1;
        int mid;
        int missingCount;

        while(lb <= ub) {
            mid = (lb + ub) / 2;
            missingCount = arr[mid] - (mid + 1);
            if(K <= missingCount) ub = mid - 1;
            else lb = mid + 1;
        }
        return K + lb;
    }
    
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; ++i)
            arr[i] = input.nextInt();
          
        int K = input.nextInt();

        int res = findKthMissingElement(arr, n, K);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
