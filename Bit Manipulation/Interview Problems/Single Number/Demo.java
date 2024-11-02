import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int singleNumber(int[] nums) {
        int temp = 0;
        for(int elem: nums) {
            temp ^= elem;
        }
        return temp;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; ++i)
            nums[i] = input.nextInt();

        int res = singleNumber(nums);
        
        output.write(res + "");

        input.close();
        output.close();
    }
}