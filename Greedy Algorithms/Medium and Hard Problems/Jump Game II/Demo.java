import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int jump(int[] nums) {
        int n = nums.length;
        int[] minJump = new int[n];
        int goal = n - 1;

        for(int i = goal - 1; i >= 0; --i) {
            if(i + nums[i] >= goal) {
                int mini = 10001;
                int M = Math.min(i + nums[i], n-1);
                for(int j = i + 1; j <= M; ++j) {
                    mini = Math.min(mini, minJump[j]);
                }
                minJump[i] = mini + 1;
                goal = i;
            }
            else minJump[i] = 10001;
        }
        return minJump[0];
    }

    // public static int solve(int[] nums, int i, int jumps) {
    //     // can be converted to DP solution i.e. O(N^2)
    //     if (i >= nums.length - 1) return jumps;

    //     int mini = Integer.MAX_VALUE;
    //     for (int j = 1; j <= nums[i]; ++j) {
    //         mini = Math.min(mini, solve(nums, i + j, jumps + 1));
    //     }
    //     return mini;
    // }

    // public static int jump(int[] nums) {
    //     return solve(nums, 0, 0);
    // }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i)
            nums[i] = input.nextInt();
        
        int res = jump(nums);
        
        output.write(Integer.toString(res));
        
        input.close();
        output.close();
    }
}