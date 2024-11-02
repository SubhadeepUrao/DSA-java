import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static int[] allDivisors(int n) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for(int i = 1; i*i <= n; ++i) { // (i <= Math.sqrt(n)) ==> (i*i <= n)
            if(n % i == 0) {
                list.add(index, i);
                ++index;
                if(n/i != i)
                    list.add(index, n/i);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        int[] res = allDivisors(n);
        
        output.write(Arrays.toString(res));

        input.close();
        output.close();
    }
}