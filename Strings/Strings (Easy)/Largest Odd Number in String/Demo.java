import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static String largestOddNumber(String num) {
        int i = num.length()-1;
        while(i >= 0) {
            char ch = num.charAt(i);
            if(ch % 2 != 0) break;
            --i;
        }
        return num.substring(0, i+1);
    }
    public static void main(String args[]) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.nextLine();

        String res = largestOddNumber(s);

        output.write(res);

        input.close();
        output.close();
    }
}