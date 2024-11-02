import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static boolean isPowerOfTwo(int num) {
        if(num <= 0) return false;
        if((num & (num-1)) == 0) return true;
        return false;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int num = input.nextInt();

        boolean res = isPowerOfTwo(num);

        output.write(Boolean.toString(res));

        input.close();
        output.close();
    }
}