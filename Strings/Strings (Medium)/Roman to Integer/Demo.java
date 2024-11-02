import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Demo {

    public static int romanToInt(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        mpp.put('I', 1);
        mpp.put('V', 5);
        mpp.put('X', 10);
        mpp.put('L', 50);
        mpp.put('C', 100);
        mpp.put('D', 500);
        mpp.put('M', 1000);

        int n = s.length();
        int sum = 0;
        for(int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if(i < n-1) {
                char nextCh = s.charAt(i+1);
                if(ch == 'I' && (nextCh == 'V' || nextCh == 'X')) {
                    sum += mpp.get(nextCh)-1;
                    ++i;
                    continue;
                }
                else if(ch == 'X' && (nextCh == 'L' || nextCh == 'C')) {
                    sum += mpp.get(nextCh)-10;
                    ++i;
                    continue;
                }
                else if(ch == 'C' && (nextCh == 'D' || nextCh == 'M')) {
                    sum += mpp.get(nextCh)-100;
                    ++i;
                    continue;
                }
            }
            sum += mpp.get(ch);
        }
        return sum;
    }
    public static void main(String args[]) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();

        int res = romanToInt(s);

        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}