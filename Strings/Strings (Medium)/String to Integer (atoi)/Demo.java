import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static int myAtoi(String s) {
        long num = 0;
        boolean neg = false;
        s = s.trim();
        int n = s.length();

        if(n == 0) return 0;

        char ch = s.charAt(0);

        if(ch == '-') neg = true;
        else if(ch == '+') neg = false;
        else if(Character.isDigit(ch)) num = ch - 48;
        else return 0;

        for(int i = 1; i < n; ++i) {
            ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = num * 10 + ch - 48;
                if(neg && num < 0) return Integer.MIN_VALUE;
                // else if(num < 0) return Integer.MAX_VALUE;
                else if(!neg && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
            else break;
        }
        if(neg) num = -num;
        if(num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)num;
    }
    public static void main(String args[]) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();

        int res = myAtoi(s);

        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}