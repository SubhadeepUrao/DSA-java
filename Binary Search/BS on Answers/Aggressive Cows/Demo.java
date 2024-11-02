import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {

    public static boolean canWePlace(int[] stalls, int k, int minDist) {
        int last = stalls[0];
        --k;
        for(int stall: stalls) {
            if(stall - last >= minDist) {
                --k;
                last = stall;
            }
        }
        if(k <= 0) return true;
        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length - 1;
        Arrays.sort(stalls);

        int lb = 1;
        int ub = stalls[n-1] - stalls[0];
        int mid;

        while(lb <= ub) {
            mid = (lb + ub) / 2;
            if(canWePlace(stalls, k, mid)) lb = mid + 1;
            else ub = mid - 1;
        }
        return ub;
    }
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int k = input.nextInt();

        int[] stalls = new int[n];
        for(int i = 0; i < n; ++i)
            stalls[i] = input.nextInt();

        int res = aggressiveCows(stalls, k);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
