import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    public static int countSubarrayXorK(int[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        int preSum = 0;
        int residue;

        for(int elem: arr) {
            preSum ^= elem;
            residue = preSum ^ k;

            count += mpp.getOrDefault(residue, 0);
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int k = input.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; ++i)
            arr[i] = input.nextInt();

        int count = countSubarrayXorK(arr, k);

        output.write(Integer.toString(count));

        input.close();
        output.close();
    }
}
