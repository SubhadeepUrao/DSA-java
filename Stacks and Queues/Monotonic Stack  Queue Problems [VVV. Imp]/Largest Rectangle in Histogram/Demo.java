import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int[] nextSmallestElements(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n];
        int top = -1;
        int[] res = new int[n];

        for(int i = n-1; i >= 0; --i) {
            while(top != -1 && heights[stack[top]] >= heights[i]) --top;

            res[i] = top == -1 ? n : stack[top];
            stack[++top] = i;
        }
        return res;
    }
    public static int[] prevSmallestElements(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n];
        int top = -1;
        int[] res = new int[n];

        for(int i = 0; i < n; ++i) {
            while(top != -1 && heights[stack[top]] >= heights[i]) --top;

            res[i] = top == -1 ? -1 : stack[top];
            stack[++top] = i;
        }
        return res;
    }
    public static int largestRectangleArea(int[] heights) {
        int[] left = prevSmallestElements(heights);
        int[] right = nextSmallestElements(heights);
        
        int maxi = 0;
        for(int i = 0; i < heights.length; ++i) {
            maxi = Math.max(maxi, (right[i] - left[i] - 1) * heights[i]);
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