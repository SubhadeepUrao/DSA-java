import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void gen(List<Integer> list, int i, int sum, int[] nums) {
        if(i == nums.length) {
            list.add(sum);
            return;
        }

        gen(list, i+1, sum + nums[i], nums);
        gen(list, i+1, sum, nums);
    }
    public static List<Integer> subsetSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        gen(list, 0, 0, nums);
        return list;
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        int[] nums = new int[n];
        for(int ind = 0; ind < n; ++ind)
            nums[ind] = input.nextInt();

        String res = subsetSum(nums).toString();

        output.write(res);

        input.close();
        output.close();
        
    }
}
