import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static int unsetRightmostSetBit(int n) {
        return n & (n - 1);
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int num = input.nextInt();

        int res = unsetRightmostSetBit(num);

        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}
