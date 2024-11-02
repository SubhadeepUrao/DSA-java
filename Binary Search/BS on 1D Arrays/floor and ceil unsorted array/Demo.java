import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int[] getFloorAndCeil(int x, int[] arr) {
        int floor = -1;
        int ceil = 1_000_001;
        for(int elem: arr) {
            if(elem == x) {
                return new int[]{x, x};
            }
            else if(elem < x) floor = Math.max(floor, elem);
            else ceil = Math.min(ceil, elem);
        }
        ceil = ceil != 1_000_001 ? ceil : -1;
        return new int[]{floor, ceil};
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

        int[] res = getFloorAndCeil(x, arr);

        output.write(res[0] + " " + res[1]);

        input.close();
        output.close();
        
    }
}
