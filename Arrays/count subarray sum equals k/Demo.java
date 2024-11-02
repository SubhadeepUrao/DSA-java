import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    
    public static int subarraySumEqualsK(int[] arr, int target) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int count = 0;
        int presum = 0;
        mpp.put(0, 1);
        for(int elem : arr) {
            presum += elem;
            int res = presum - target;
            count += mpp.getOrDefault(res, 0);

            mpp.put(presum, mpp.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int target = input.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        
        int count = subarraySumEqualsK(arr, target);

        output.write(Integer.toString(count));

        input.close();
        output.close();
        
    }
}
