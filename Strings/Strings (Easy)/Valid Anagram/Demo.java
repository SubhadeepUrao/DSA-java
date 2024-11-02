import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static boolean isAnagram(String s, String t) {
        int n = s.length();

        if(n != t.length()) return false;

        int[] mapped = new int[26];

        for(int i = 0; i < n; ++i) {
            ++mapped[s.charAt(i)-97];
            --mapped[t.charAt(i)-97];
        }
        
        for(int i = 0; i < 26; ++i) {
            if(mapped[i] != 0) return false;
        }
        return true;
    }

    public static void main(String args[]) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();
        String t = input.next();

        boolean res = isAnagram(s, t);

        output.write(Boolean.toString(res));

        input.close();
        output.close();
    }
}