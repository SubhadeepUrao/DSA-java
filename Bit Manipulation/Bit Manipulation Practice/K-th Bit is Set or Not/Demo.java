import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static boolean checkKthBit(int num, int i) {
        int temp = 1 << i;
        if((temp & num) == 0) return false;
        return true;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int num = input.nextInt();
        int pos = input.nextInt();

        boolean res = checkKthBit(num, pos);

        output.write(Boolean.toString(res));

        input.close();
        output.close();
    }
}