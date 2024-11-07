import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal {
    // public static int largestRectangleArea(int[] heights) {
    //     int n = heights.length;
    //     int[] stack = new int[n];
    //     int top = -1;
    //     int maxi = 0;

    //     for(int i = 0; i < n; ++i) {
            
    //         while(top != -1 && heights[stack[top]] > heights[i]) {
    //             int curr = stack[top--];
    //             int pse = top == -1 ? -1 : stack[top];
    //             maxi = Math.max(maxi, heights[curr] * (i - pse - 1));
    //         }

    //         stack[++top] = i;
    //     }

    //     do {
    //         int curr = stack[top--];
    //         int pse = top == -1 ? -1 : stack[top];
    //         maxi = Math.max(maxi, heights[curr] * (n - pse - 1));
    //     } while(top != -1);

    //     return maxi;
    // }

    // public static int largestRectangleArea(int[] heights) {
    //     int n = heights.length;
    //     int[] stack = new int[n+1];
    //     int top = -1;
    //     int maxi = 0;

    //     for(int i = 0; i <= n; ++i) {
    //         int height = i == n ? 0 : heights[i];
            
    //         while(top != -1 && heights[stack[top]] > height) {
    //             int curr = stack[top--];
    //             int pse = top == -1 ? -1 : stack[top];
    //             maxi = Math.max(maxi, heights[curr] * (i - pse - 1));
    //         }

    //         stack[++top] = i;
    //     }

    //     return maxi;
    // }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n+1];
        int top = -1;
        int maxi = 0;

        for(int i = 0; i <= n; ++i) {
            int currHeight = i == n ? 0 : heights[i];
            
            while(top != -1 && heights[stack[top]] > currHeight) {
                int height = heights[stack[top--]];
                int width = top == -1 ? i : i - stack[top] - 1;
                maxi = Math.max(maxi, height * width);
            }

            stack[++top] = i;
        }

        return maxi;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();
        
        int res = largestRectangleArea(nums);

        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}
