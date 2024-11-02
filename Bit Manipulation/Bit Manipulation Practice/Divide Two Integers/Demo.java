import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        else if (dividend == Integer.MIN_VALUE && divisor == 1)
            return Integer.MIN_VALUE;

        boolean neg = (dividend < 0) ^ (divisor < 0);

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long ans = 0;

        while (n >= d) {
            int cnt = 0;
            while (n >= (d << (cnt + 1))) { // d * 2^(cnt+1) ==> d << (cnt+1)
                cnt++;
            }
            ans += 1L << cnt;
            n -= d << cnt;
        }

        if (ans > Integer.MAX_VALUE)
            return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        return neg ? (int) -ans : (int) ans;
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int dividend = input.nextInt();
        int divisor = input.nextInt();

        int res = divide(dividend, divisor);

        output.write(res + "");

        input.close();
        output.close();
    }
}