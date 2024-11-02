import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DemoRecursive {

    public static long myPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 != 0) {
                result = result * base % 1000_000_007L;
            }
            base = base * base % 1000_000_007L;
            exp /= 2;
        }
        return result;
    }
    
    public static int countGoodNumbers(long n) {
        if(n == 0) return 1;
        
        if(n % 2 == 1) {
            return (int)(myPow(20, n/2) * 5L % 1000_000_007L);
        }
        return (int)(myPow(20, n/2) % 1000_000_007L);
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        long n = input.nextLong();

        int res = countGoodNumbers(n);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
