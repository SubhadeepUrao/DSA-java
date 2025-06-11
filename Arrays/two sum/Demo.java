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

    for (int i = 0; i < arr.length; ++i) {
      int num = arr[i];
      int needed = target - num;
      if (mpp.containsKey(needed)) {
        res[1] = mpp.get(needed);
        res[0] = i;
        return res;
      }
      mpp.put(num, i);
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
    for (int i = 0; i < n; i++) {
      arr[i] = input.nextInt();
    }

    int[] res = twoSum(arr, k);
    output.write(Integer.toString(res[0]) + " " + Integer.toString(res[1]));

    input.close();
    output.close();

  }
}
