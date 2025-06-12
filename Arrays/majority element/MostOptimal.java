import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MostOptimal {
  public static int majorityElement(int[] arr) {
    int n = arr.length;
    int elem = arr[0]; // possible majority candidate
    int count = 1;

    for (int i = 1; i < n; ++i) {
      if (count == 0) {
        elem = arr[i];
        count = 1;
      } else if (elem == arr[i])
        ++count;
      else
        --count;
    }

    // this below snippet is required since we have assumed that majority element
    // might exist, otherwise return elem.
    count = 0;
    for (int i = 0; i < n; ++i) {
      if (elem == arr[i])
        ++count;
    }

    return count > (n >> 1) ? elem : -1;
  }

  public static void main(String[] args) throws IOException {
    File inputfile = new File("input.txt");
    Scanner input = new Scanner(inputfile);
    FileWriter output = new FileWriter("output.txt");

    int n = input.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = input.nextInt();
    }

    output.write(Integer.toString(majorityElement(arr)) + " ");

    input.close();
    output.close();

  }
}
