import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    
    public static int nthRoot(int n, int m) {
        int lb = 1;
        int ub = m;
        int mid;

        while(lb <= ub) {
            mid = (lb + ub) / 2;
            if(Math.pow(mid, n) == m) return mid;
            if(Math.pow(mid, n) < m) lb = mid + 1;
            else ub = mid - 1;
        }
        return -1;
    }
    
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int m = input.nextInt();

        int res = nthRoot(n, m);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
