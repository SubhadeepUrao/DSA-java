import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    static int findAvgWaitingTime(int bt[] ) {
        Arrays.sort(bt);
        int wt = 0;
        int time = 0;
        
        for(int shortJob : bt) {
            wt += time;
            time += shortJob;
        }
        return wt / bt.length;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i)
            nums[i] = input.nextInt();
        
        int res = findAvgWaitingTime(nums);
        
        output.write(Integer.toString(res));
        
        input.close();
        output.close();
    }
}