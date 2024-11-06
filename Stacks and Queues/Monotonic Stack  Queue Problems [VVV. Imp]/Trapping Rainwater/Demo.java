import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int waterLog = 0;

        while (left <= right) {
            // This change in condition still achieves correct results because the logic
            // hinges on always processing the side with the smaller effective boundary.
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                waterLog += leftMax - height[left];
                ++left;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                waterLog += rightMax - height[right];
                --right;
            }
        }
        return waterLog;
    }

    // public static int trap(int[] height) {
    //     int left = 0;
    //     int right = height.length - 1;
    //     int leftMax = 0;
    //     int rightMax = 0;
    //     int waterLog = 0;

    //     while (left <= right) {
    //         if (height[left] <= height[right]) {
    //             leftMax = Math.max(leftMax, height[left]);
    //             waterLog += leftMax - height[left];
    //             ++left;
    //         } else {
    //             rightMax = Math.max(rightMax, height[right]);
    //             waterLog += rightMax - height[right];
    //             --right;
    //         }
    //     }
    //     return waterLog;
    // }

    // public static int trap(int[] height) {
    //     int left = 0;
    //     int right = height.length - 1;
    //     int leftMax = height[left];
    //     int rightMax = height[right];
    //     int waterLog = 0;

    //     // here we don't have to use left <= right
    //     while (left < right) {
    //         if (leftMax <= rightMax) {
    //             ++left;
    //             leftMax = Math.max(leftMax, height[left]);
    //             waterLog += leftMax - height[left];
    //         } else {
    //             --right;
    //             rightMax = Math.max(rightMax, height[right]);
    //             waterLog += rightMax - height[right];
    //         }
    //     }
    //     return waterLog;
    // }

    // public static int trap(int[] height) {
    //     int[] trapped = new int[height.length];

    //     int max = -1;
    //     for (int i = height.length - 1; i >= 0; --i) {
    //         if (max < height[i])
    //             max = height[i];
    //         trapped[i] = max;
    //     }

    //     int waterLog = 0;

    //     max = -1;
    //     for (int i = 0; i < height.length; ++i) {
    //         if (max < height[i])
    //             max = height[i];
    //         waterLog += Math.min(trapped[i], Math.max(max, height[i])) - height[i];
    //     }

    //     return waterLog;
    // }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i)
            nums[i] = input.nextInt();

        int res = trap(nums);

        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}