import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static int findExponent(int y, int cnt) {
        while (y != (1 << cnt) ) {
            cnt++;
        }
        return cnt;
    }
    public static List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int end = (1 << nums.length);

        for(int i = 0; i < end; ++i) {
            int index = 0;
            List<Integer> sublist = new ArrayList<>();
            int n = i;
            while(n != 0) {
                int temp = n ^ (n-1) & n;
                index = findExponent(temp, index);
                sublist.add(nums[index]);
                n = n & (n-1);
            }
            list.add(sublist);
        }
        return list;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; ++i)
            nums[i] = input.nextInt();
        
        List<List<Integer>> res = powerSet(nums);

        output.write(res.toString());

        input.close();
        output.close();
    }
}