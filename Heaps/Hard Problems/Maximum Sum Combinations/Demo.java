import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Demo {
    
    public static int[] maxSumCombinations(int[] nums1, int[] nums2, int c) {
        int[] res = new int[c];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums1.length;
        
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                pq.add(nums1[i] + nums2[j]);
            }
        }

        for(int i = 0; i < c; ++i)
            res[i] = pq.remove();
        
        return res;
    }
    
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();

        int[] nums1 = new int[N];
        for(int i = 0; i < N; ++i)
            nums1[i] = input.nextInt();

        int[] nums2 = new int[N];
        for(int i = 0; i < N; ++i)
            nums2[i] = input.nextInt();

        int c = input.nextInt();
        
        int[] res = maxSumCombinations(nums1, nums2, c);
        
        output.write(Arrays.toString(res));
        
        input.close();
        output.close();
    }
}