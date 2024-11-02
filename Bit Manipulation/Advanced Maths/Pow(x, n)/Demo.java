import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    // log N
    public static int pow(int x, int n) {
        if(n == 0 || x == 1) return 1;
        if(n == 1) return x;

        if(n < 0) {
            if(n == Integer.MIN_VALUE) return 1/(x * pow(x, n-1));
            return 1/pow(x, -n);
        }

        return n % 2 == 0 ? pow(x*x, n >> 1) : x * pow(x*x, n >> 1);
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int base = input.nextInt();
        int exp = input.nextInt();

        int res = pow(base, exp);

        output.write(res + "");

        input.close();
        output.close();
    }
}