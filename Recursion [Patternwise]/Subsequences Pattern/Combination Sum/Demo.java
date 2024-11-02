import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void gen(List<List<Integer>> list, List<Integer> sublist, int i, int n, int target, int[] nums) {
        if(i == n) {
            if(target == 0) list.add(new ArrayList<>(sublist));
            return;
        }

        if(nums[i] <= target) {
            sublist.add(nums[i]);
            gen(list, sublist, i, n, target - nums[i], nums);
            sublist.remove(sublist.size() - 1);
        }
        gen(list, sublist, i+1, n, target, nums);
    }
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        gen(list, new ArrayList<>(), 0, nums.length, target, nums);
        return list;
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int target = input.nextInt();

        int[] nums = new int[n];
        for(int i = 0; i < n; ++i)
            nums[i] = input.nextInt();

        String res = combinationSum(nums, target).toString();

        output.write(res);

        input.close();
        output.close();
        
    }
}
