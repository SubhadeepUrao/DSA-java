import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static int myPow(int base, int exp) {
        if(exp == 1) return base;
        if(exp % 2 == 0)
            return myPow(base*base, exp/2);
        return base * myPow(base*base, exp/2);
    }
    public static String generate(int k, int num, int prevRem) {
        if(k == 0) return "";
        int currRem = num % 2;
        num = num / 2;
        if(prevRem + currRem == 2) return "";
        return generate(--k, num, currRem) + currRem;
    }
    public static String binRepWithoutConsecutive1(int k) {
        int limit = myPow(2, k);
        // int limit = 1 << k;

        ArrayList<String> s = new ArrayList<>();
        for(int i = 0; i < limit; ++i) {
            String str = generate(k, i, 0);
            if(str.length() == k) {
                s.add(str);
            }
        }
        return s.toString();
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int k = input.nextInt();

        String res = binRepWithoutConsecutive1(k);

        output.write(res);

        input.close();
        output.close();
        
    }
}
