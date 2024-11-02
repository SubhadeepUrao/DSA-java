import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static int pascalTriangleVar1(int n, int r) {
        int num = 1;
        n--;
        r--;
        for(int i = 0; i < r; ++i) {
            num *= n - i;
            num /= i + 1;
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        FileWriter output = new FileWriter("output.txt");

        Scanner input = new Scanner(file);

        int row = input.nextInt();
        int col = input.nextInt();

        int res = pascalTriangleVar1(row, col);

        output.write(Integer.toString(res));

        // List<List<Integer>> list = new ArrayList<>();
        // list.add(Arrays.asList(1));
        // System.out.println(list);

        input.close();
        output.close();
    }
}