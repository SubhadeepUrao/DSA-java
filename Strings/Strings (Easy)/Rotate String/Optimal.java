import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal {

    public static boolean rotateString(String str, String goal) {
        int n = str.length();
        if(n != goal.length()) return false;
        int cnt = 0;
        int j = 0;
        for(int i = 0; i < 2*n; ++i) {
            if(str.charAt(i % n) == goal.charAt(j % n)) {
                ++j;
                ++cnt;
                if(cnt == n) return true;
            }
            else cnt = 0;
        }
        return false;
    }
    public static void main(String args[]) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();
        String t = input.next();

        boolean res = rotateString(s, t);

        output.write(Boolean.toString(res));

        input.close();
        output.close();
    }
}