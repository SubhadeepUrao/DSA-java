import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static List<Integer> swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        // return Arrays.asList(a, b);
        return List.of(a, b);
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int a = input.nextInt();
        int b = input.nextInt();

        List<Integer> res = swap(a, b);

        output.write(res.toString());

        input.close();
        output.close();
    }
}
