import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {

    // 780, 37
    public static int[] allPrimeFactors(int N) {
        List<Integer> list = new ArrayList<>();

        for(int i = 2; i <= Math.sqrt(N); ++i) { // sqrt(N)
            if(N % i == 0) {
                list.add(i);

                do { // log N
                    N /= i;
                } while(N % i == 0);
            }
        }
        if(N != 1) list.add(N);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();

        int[] res = allPrimeFactors(N);
        
        output.write(Arrays.toString(res));

        input.close();
        output.close();
    }
}