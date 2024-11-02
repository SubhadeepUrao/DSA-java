import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static int maxDepth(String s) {
        int count=0,max=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            count++;
            max=Math.max(count,max);
            if(s.charAt(i)==')')
            count--;
        }
        return max;
    }
    public static void main(String args[]) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();

        int res = maxDepth(s);

        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}