import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



// optimal for (-ve < n < +ve) for all values
public class Demo {
    public static int longSubarraySumK(int[] arr, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            if(sum == k) maxLen = Math.max(maxLen, i+1);

            if(mpp.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - mpp.get(sum - k));
            }
            
            if(!mpp.containsKey(sum)) {
                mpp.put(sum, i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int k = input.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        
        output.write(Integer.toString(longSubarraySumK(arr, k)));

        input.close();
        output.close();
        
    }
}
