import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int helper(int num) {
        if(num % 4 == 1) return 1;
        if (num % 4 == 2) return num + 1;
        if(num % 4 == 3) return 0;
        return num;
    }
    public static int findXOR(int l, int r) {
        return helper(l-1) ^ helper(r);
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int left = input.nextInt();
        int right = input.nextInt();

        int res = findXOR(left, right);
        
        output.write(res + "");

        input.close();
        output.close();
    }
}