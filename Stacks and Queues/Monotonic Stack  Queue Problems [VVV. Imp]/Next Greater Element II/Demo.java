import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Demo {
    public static int[] nextGreaterElementII(int[] nums) {
        int[] res = new int[nums.length];
        int[] stack = new int[nums.length];
        int top = -1;

        for(int i = nums.length-1; i >= 0; --i) {
            while(top != -1 && stack[top] <= nums[i]) --top;

            if(top == -1) {
                res[i] = -1;
                for(int j = 0; j < i; ++j) {
                    if(nums[j] > nums[i]) {
                        res[i] = nums[j];
                        break;
                    }
                }
            }
            else res[i] = stack[top];

            stack[++top] = nums[i];
        }
        return res;
    }
    
    // public static int[] nextGreaterElementII(int[] nums) {
    //     int[] res = new int[nums.length];
    //     Stack<Integer> st = new Stack<>();

    //     for(int i = nums.length-1; i >= 0; --i) {
    //         while(!st.empty() && st.peek() <= nums[i]) st.pop();

    //         if(st.empty()) {
    //             res[i] = -1;
    //             for(int j = 0; j < i; ++j) {
    //                 if(nums[j] > nums[i]) {
    //                     res[i] = nums[j];
    //                     break;
    //                 }
    //             }
    //         }
    //         else res[i] = st.peek();

    //         st.push(nums[i]);
    //     }
    //     return res;
    // }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i)
            nums[i] = input.nextInt();

        int[] res = nextGreaterElementII(nums);

        output.write(Arrays.toString(res));

        input.close();
        output.close();
    }
}