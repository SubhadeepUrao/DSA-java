import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static String oddEven(int n) {
        if((n & 1) == 0) return "even";
        return "odd";
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int num = input.nextInt();

        String res = oddEven(num);

        output.write(res);

        input.close();
        output.close();
    }
}