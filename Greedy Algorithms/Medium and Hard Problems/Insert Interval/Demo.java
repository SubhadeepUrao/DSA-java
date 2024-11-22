import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while(i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while(i < n) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(int[][]::new);
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
        int[] interval = new int[2];
        interval[0] = input.nextInt();
        interval[1] = input.nextInt();
        
        int[][] res = insert(nums, interval);
        
        output.write(Arrays.deepToString(res));
        
        input.close();
        output.close();
    }
}