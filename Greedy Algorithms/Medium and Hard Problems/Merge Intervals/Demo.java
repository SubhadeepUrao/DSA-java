import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int last = 0;
        int n = intervals.length;

        for(int i = 1; i < n; ++i) {
            if(intervals[last][1] < intervals[i][0]) {
                ++last;
                intervals[last] = intervals[i];
            }
            else
                intervals[last][1] = Math.max(intervals[last][1], intervals[i][1]);
        }
        int[][] res = new int[last+1][2];
        for(int i = 0; i <= last; ++i)
            res[i] = intervals[i];
        return res;
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[][] nums = new int[n][2];
        for(int i = 0; i < n; ++i) {
            nums[i][0] = input.nextInt();
            nums[i][1] = input.nextInt();
        }
        
        int[][] res = merge(nums);
        
        output.write(Arrays.deepToString(res));
        
        input.close();
        output.close();
    }
}