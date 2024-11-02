import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
 
public class Demo {
    public static int[] twoSum(int[] arr, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> mpp = new HashMap<>();

        for(int i = 0; i < arr.length; ++i) {
            mpp.put(arr[i], i);
        }
        
        for(int i = 0; i < arr.length; ++i) {
            mpp.remove(arr[i], i);
            if(mpp.containsKey(target - arr[i])) {
                res[1] = mpp.get(target - arr[i]);
                res[0] = i;
                return res;
            }
        }
        
        return res;
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
        
        int[] res = twoSum(arr, k);
        output.write(Integer.toString(res[0]) + " " + Integer.toString(res[1]));

        input.close();
        output.close();
        
    }
}
