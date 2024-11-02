import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    public static int longestSubarraySumZero(int[] arr) {
        Map<Long, Integer> mpp = new HashMap<>();
        mpp.put(0l, -1);
        int maxLen = 0;
        int n = arr.length;
        long preSum = 0;
        for(int i = 0; i < n; ++i) {
            preSum += arr[i];

            if(mpp.containsKey(preSum)) {
                int len = i - mpp.getOrDefault(preSum, i);
                maxLen = Math.max(maxLen, len);
            }
            else
                mpp.put(preSum, i);
        }
        return maxLen;
    }
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; ++i)
            arr[i] = input.nextInt();

        int count = longestSubarraySumZero(arr);

        output.write(Integer.toString(count));

        input.close();
        output.close();
    }
}

