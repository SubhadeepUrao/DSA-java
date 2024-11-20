import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static boolean canJump(int[] nums) {
        int goal = nums.length-1;
        for(int i = goal-1 ; i >= 0; --i) {
            if(i + nums[i] >= goal)
                goal = i;
        }
        return goal == 0;
    }

    // public static boolean canJump(int[] nums) {
    //     int maxi = nums[0];
    //     int n = nums.length;
    //     int goal = n-1;
    //     for(int i = 1; i < n; ++i) {
    //         if(i > maxi) return false;
    //         if(maxi < nums[i] + i)
    //             maxi = nums[i] + i;
    //         if(maxi >= goal) return true;
    //     }
    //     return true;
    // }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i)
            nums[i] = input.nextInt();
        
        boolean res = canJump(nums);
        
        output.write(Boolean.toString(res));
        
        input.close();
        output.close();
    }
}