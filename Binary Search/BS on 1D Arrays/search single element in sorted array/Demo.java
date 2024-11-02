import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    
    public static int singleNonDuplicate(int[] arr) {
        int n = arr.length;

        if (n == 1)
            return arr[0];
        if (!(arr[0] == arr[1]))
            return arr[0];
        if (!(arr[n - 1] == arr[n - 2]))
            return arr[n - 1];

        int lb = 1;
        int ub = n-2;
        int mid;

        while(lb <= ub) {

            mid = (lb + ub) / 2;

            if(mid < ub && arr[mid] == arr[mid+1]) {
                if(mid % 2 == 0) lb = mid + 2;
                else ub = mid - 1;
            }
            else if(mid > lb && arr[mid-1] == arr[mid]) {
                if(mid % 2 == 0) ub = mid - 2;
                else lb = mid + 1;
            }
            else return arr[mid];
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

        int res = singleNonDuplicate(arr);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
