import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static boolean doesArrayRepresentHeap(int[] nums) {
        for(int i = 1; i < nums.length; ++i) {
            if(nums[(i - 1) >> 1] < nums[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();
        
        boolean res = doesArrayRepresentHeap(nums);
        
        output.write(Boolean.toString(res));
        
        input.close();
        output.close();
    }
}