import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static String removeOuterParentheses(String s) {
        StringBuilder str = new StringBuilder();
        int cnt = 0;
        int n = s.length();

        for(int i = 1; i < n; ++i) {
            if(s.charAt(i) == '(') {
                ++cnt;
                str.append('(');
            }
            else {
                if(cnt == 0) ++i;
                else {
                    --cnt;
                    str.append(')');
                }
            }
        }
        return str.toString();
    }
    public static void main(String args[]) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.nextLine();

        String res = removeOuterParentheses(s);

        output.write(res);

        input.close();
        output.close();
    }
}