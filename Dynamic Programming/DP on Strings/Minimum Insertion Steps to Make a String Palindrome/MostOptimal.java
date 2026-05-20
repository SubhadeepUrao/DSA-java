import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MostOptimal {

    static int minInsertionSteps(char[] str) {
        int N = str.length;
        int[] prev = new int[N];

        for (int l = N - 2; l >= 0; --l) {
            int diagonal = 0;
            for (int r = l + 1; r < N; ++r) {
                int temp = prev[r];
                prev[r] = str[l] == str[r] ? diagonal : 1 + Math.min(prev[r - 1], prev[r]);
                diagonal = temp;
            }
        }
        return prev[N - 1];
    }

    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String str = input.next();
        int res = minInsertionSteps(str.toCharArray());
        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}
