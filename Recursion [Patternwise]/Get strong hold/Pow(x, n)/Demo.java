import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    
    public static double myPow(double x, int n) {
        if(n == 0 || x == 1) return 1;
        if(n == 1) return x;
        if(n < 0) {
            // edge case: int range => 2^31 to 2^31-1
            if(n == Integer.MIN_VALUE) return 1/(x * myPow(x, n-1));
            return 1/myPow(x, -n);
        }

        if(n%2 == 1) {
            return x * myPow(x*x, n/2);
        }
        return myPow(x*x, n/2);
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        double x = input.nextDouble();
        int n = input.nextInt();

        double res = myPow(x,n);

        output.write(Double.toString(res));

        input.close();
        output.close();
        
    }
}