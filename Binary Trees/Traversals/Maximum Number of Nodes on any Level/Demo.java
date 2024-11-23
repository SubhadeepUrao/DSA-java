import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    static int myPow(int base, int exp) {
        if(exp == 0 || base == 1) return 1;
        
        if(exp % 2 == 0) return myPow(base * base, exp >> 1);
        return base * myPow(base * base, exp >> 1);
    }
    static int countNodes(int i) {
        return myPow(2, i - 1);
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");
        
        int level = input.nextInt();

        int res = countNodes(level);

        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}