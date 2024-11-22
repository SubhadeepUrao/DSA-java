import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int n = intervals.length;
        int pair = intervals[0][1];
        int cnt = 1;

        for(int i = 1; i < n; ++i) {
            if(pair <= intervals[i][0]) {
                pair = intervals[i][1];
                cnt++;
            }
        }
        return n-cnt;
    }

    // public static int eraseOverlapIntervals(int[][] intervals) {
    //     Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
    //     int n = intervals.length;
    //     int pair = intervals[0][1];
    //     int cnt = 0;

    //     for(int i = 1; i < n; ++i) {
    //         if(pair <= intervals[i][0])
    //             pair = intervals[i][1];
    //         else
    //             cnt++;
    //     }
    //     return cnt;
    // }

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
        
        int res = eraseOverlapIntervals(nums);
        
        output.write(Integer.toString(res));
        
        input.close();
        output.close();
    }
}