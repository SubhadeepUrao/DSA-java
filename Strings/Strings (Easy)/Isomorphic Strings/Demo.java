import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static boolean isIsomorphic(String s, String t) {
        int slen = s.length();
        int tlen = t.length();

        if(slen != tlen) return false;

        for(int i = 0; i < slen; ++i) {
            int sPos = s.indexOf(s.charAt(i));
            int tPos = t.indexOf(t.charAt(i));
            if(sPos != tPos) return false;
        }
        return true;
    }
    public static void main(String args[]) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();
        String t = input.next();

        boolean res = isIsomorphic(s, t);

        output.write(Boolean.toString(res));

        input.close();
        output.close();
    }
}