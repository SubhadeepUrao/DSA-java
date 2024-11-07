import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static String removeKDigits(String num, int k) {
        int n = num.length();
        if(n == k) return "0";

        char[] stack = new char[n];
        int top = -1;

        for(int i = 0; i < n; ++i) {
            char digit = num.charAt(i);

            while(k > 0 && top != -1 && stack[top] > digit) {
                --top;
                --k;
            }

            if(digit != '0' || top != -1)
                stack[++top] = digit;
        }

        if(k > 0) {
            if(top - k >= 0) top -= k;
            else return "0";
        }

        return top == -1 ? "0" : new String(stack, 0, top + 1);
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        String num = input.next();
        int k = input.nextInt();

        String res = removeKDigits(num, k);

        output.write(res);

        input.close();
        output.close();
    }
}