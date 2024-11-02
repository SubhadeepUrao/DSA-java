import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    // returns values, -1 for not availablility
    public static int[] floorAndCeil(int[] arr, int x) {
        int mid;
        int n = arr.length;
        int lb = 0;
        int ub = n - 1;
        while(lb <= ub) {
            mid = (lb + ub) / 2;
            if(x <= arr[mid]) ub = mid - 1;
            else lb = mid + 1;
        }

        if(lb < n && arr[lb] == x) return new int[]{x, x};

        int ceil = lb < n ? arr[lb] : -1;
        int floor = lb > 0 ? arr[lb - 1] : -1;

        return new int[] {floor, ceil};
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

        int[] res = floorAndCeil(arr, x);

        output.write(res[0] + " " + res[1]);

        input.close();
        output.close();
        
    }
}
