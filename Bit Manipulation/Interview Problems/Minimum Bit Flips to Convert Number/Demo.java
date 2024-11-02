import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int minBitFlips(int start, int goal) {
        int temp = start ^ goal;
        int cnt = 0;
        while(temp != 0) {
            cnt++;
            temp = temp & (temp-1);
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int start = input.nextInt();
        int goal = input.nextInt();

        int res = minBitFlips(start, goal);

        output.write(res + "");

        input.close();
        output.close();
    }
}