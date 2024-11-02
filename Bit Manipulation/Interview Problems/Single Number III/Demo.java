import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Demo {
    // public static int[] twoOddNum(int[] nums) {
    //     HashSet<Integer> hs = new HashSet<>();

    //     for(int elem: nums) {
    //         if(hs.contains(elem)) hs.remove(elem);
    //         else hs.add(elem);
    //     }
    //     int[] res = hs.stream().mapToInt(Integer::intValue).toArray();
    //     if (res[0] < res[1]) {
    //         res[0] = res[0] ^ res[1];
    //         res[1] = res[0] ^ res[1];
    //         res[0] = res[0] ^ res[1];
    //     }
    //     return res;
    // }
    public static int[] twoOddNum(int[] nums) {
        int xor = 0;
        for (int elem : nums)
            xor ^= elem;
        int rightmost = xor & (xor - 1) ^ xor;
        int b1 = 0;
        int b2 = 0;
        for (int elem : nums) {
            if ((elem & rightmost) == 0)
                b1 ^= elem;
            else
                b2 ^= elem;
        }
        return b1 < b2 ? new int[] { b2, b1 } : new int[] { b1, b2 };
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; ++i)
            nums[i] = input.nextInt();
        
        int[] res = twoOddNum(nums);

        output.write(res[0] + " " + res[1]);

        input.close();
        output.close();
    }
}