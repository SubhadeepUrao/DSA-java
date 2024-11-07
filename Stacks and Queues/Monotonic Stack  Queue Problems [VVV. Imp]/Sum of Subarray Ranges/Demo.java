import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int[] nextSmallerElems(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;
        int[] res = new int[n];

        for(int i = n-1; i >= 0; --i) {
            while(top != -1 && nums[stack[top]] >= nums[i]) --top;
            res[i] = top == -1 ? n - i : stack[top] - i;
            stack[++top] = i;
        }
        return res;
    }
    public static int[] prevSmallerOrEqualElems(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;
        int[] res = new int[n];

        for(int i = 0; i < n; ++i) {
            while(top != -1 && nums[stack[top]] > nums[i]) --top;
            res[i] = top == -1 ? i + 1 : i - stack[top];
            stack[++top] = i;
        }
        return res;
    }
    public static int[] nextGreaterElems(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;
        int[] res = new int[n];

        for(int i = n-1; i >= 0; --i) {
            while(top != -1 && nums[stack[top]] <= nums[i]) --top;
            res[i] = top == -1 ? n - i : stack[top] - i;
            stack[++top] = i;
        }
        return res;
    }
    public static int[] prevGreaterOrEqualElems(int[] nums) {
        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;
        int[] res = new int[n];

        for(int i = 0; i < n; ++i) {
            while(top != -1 && nums[stack[top]] < nums[i]) --top;
            res[i] = top == -1 ? i + 1 : i - stack[top];
            stack[++top] = i;
        }
        return res;
    }

    public static long subArrayRanges(int[] nums) {
        int[] left = prevSmallerOrEqualElems(nums);
        int[] right = nextSmallerElems(nums);
        long total = 0;

        for(int i = 0; i < nums.length; ++i)
            total -= (long)left[i] * right[i] * nums[i];
        
        left = prevGreaterOrEqualElems(nums);
        right = nextGreaterElems(nums);

        for(int i = 0; i < nums.length; ++i)
            total += (long)left[i] * right[i] * nums[i];
        
        return total;
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();
        
        long res = subArrayRanges(nums);

        output.write(Long.toString(res));

        input.close();
        output.close();
    }
}
