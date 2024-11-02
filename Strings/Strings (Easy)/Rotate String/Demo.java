import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static boolean rotateString(String str, String goal) {
        String newstr = str + str; //str.concat(str)
        if(newstr.contains(goal) && str.length() == goal.length()) return true;
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