import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static List<String> gen(List<String> list, StringBuilder str, int open, int close, int n) {
        if(open == n && close == n) {
            list.add(str.toString());
            return list;
        }
        if(open < n) {
            str.append('(');
            gen(list, str, open+1, close, n);
            str.setLength(open+close);
        }
        if(close < open) {
            str.append(')');
            gen(list, str, open, close+1, n);
            str.setLength(open+close);
        }
        return list;
    }
    public static List<String> genParanthesis(int n) {
        return gen(new ArrayList<>(), new StringBuilder(), 0, 0, n);
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        String res = genParanthesis(n).toString();

        output.write(res);

        input.close();
        output.close();
        
    }
}
