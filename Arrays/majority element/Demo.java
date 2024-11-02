import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    public static int majorityElement(int[] arr) {
        Map <Integer, Integer> mpp = new HashMap<>();

        for(int i = 0; i < arr.length; ++i) {
            Integer val = mpp.get(arr[i]);
            if(val != null) {
                mpp.put(arr[i], ++val);
            }
            else mpp.put(arr[i], 1);
        }
        int majorElem = 0;
        int majorVal = 0;
        for(Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            if(majorVal < entry.getValue()) {
                majorElem = entry.getKey();
                majorVal = entry.getValue();
            }
        }
        return majorElem;
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        
        output.write(Integer.toString(majorityElement(arr)) + " ");

        input.close();
        output.close();
        
    }
}
