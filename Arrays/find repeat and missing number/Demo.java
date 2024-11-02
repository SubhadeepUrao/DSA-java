import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Demo {
    public static int[] findRepeatMissing(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int[] res = {0, 0};
        long sum = 0;
        long repeat = 0;
        for(int elem: arr) {
            if(set.contains(elem)) {
                repeat = elem;
            }
            else set.add(elem);

            sum += elem;
        }
        long n = arr.length;
        res[1] = (int)((n*n + n) / 2 - sum + repeat);
        res[0] = (int)repeat;
        return res;
    }
    
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        FileWriter output = new FileWriter("output.txt");


        int n = input.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; ++i) {
            arr[i] = input.nextInt();
        }

        int[] res = findRepeatMissing(arr);

        output.write(res[0] + " " + res[1]);
        

        input.close();
        output.close();
    }
}