import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Demo {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int i = nums2.length-1; i >= 0; --i) {
            while(!st.empty() && st.peek() < nums2[i])
                st.pop();
            
            if(st.empty()) mpp.put(nums2[i], -1);
            else mpp.put(nums2[i], st.peek());

            st.push(nums2[i]);
        }

        for(int i = 0; i < nums1.length; ++i)
            res[i] = mpp.get(nums1[i]);
        
        return res;
    }

    // public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    //     int[] res = new int[nums1.length];
    //     Stack<Integer> st = new Stack<>();
    //     int[] vocab = new int[10001];

    //     for(int i = nums2.length-1; i >= 0; --i) {
    //         while(!st.empty() && st.peek() < nums2[i])
    //             st.pop();
            
    //         if(!st.empty()) vocab[nums2[i]] = st.peek();
    //         else vocab[nums2[i]] = -1;

    //         st.push(nums2[i]);
    //     }

    //     for(int i = 0; i < nums1.length; ++i)
    //         res[i] = vocab[nums1[i]];

    //     return res;
    // }

    // public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    //     int[] vocab = new int[10001];
    //     int[] result = new int[nums1.length];
    //     for (int i = 0; i < nums2.length; i++) vocab[nums2[i]] = i;
    //     for (int i = 0; i < nums1.length; i++) result[i] = greater(vocab[nums1[i]], nums2);
    //     return result;
    // }
    // public int greater(int idx, int[] nums2) {
    //     for (int j = idx + 1; j < nums2.length; j++) {
    //         if (nums2[j] > nums2[idx]) return nums2[j];
    //     }
    //     return -1;
    // }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] nums1 = new int[n];
        for(int i = 0; i < n; ++i)
            nums1[i] = input.nextInt();

        int m = input.nextInt();
        int[] nums2 = new int[m];
        for(int i = 0; i < m; ++i)
            nums2[i] = input.nextInt();

        int[] res = nextGreaterElement(nums1, nums2);

        output.write(Arrays.toString(res));

        input.close();
        output.close();
    }
}