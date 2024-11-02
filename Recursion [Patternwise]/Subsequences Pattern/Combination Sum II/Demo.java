import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void gen(List<List<Integer>> list, List<Integer> sublist, int ind, int target, int[] nums) {
        if(target == 0) {
            list.add(new ArrayList<>(sublist));
            return;
        }

        for(int i = ind; i < nums.length; ++i) {
            if(i > ind && nums[i] == nums[i-1]) continue;
            if(nums[i] > target) break;

            sublist.add(nums[i]);
            gen(list, sublist, i+1, target - nums[i], nums);
            sublist.remove(sublist.size() - 1);
        }
    }
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        gen(list, new ArrayList<>(), 0, target, nums);
        return list;
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int target = input.nextInt();

        int[] nums = new int[n];
        for(int ind = 0; ind < n; ++ind)
            nums[ind] = input.nextInt();

        String res = combinationSum2(nums, target).toString();

        output.write(res);

        input.close();
        output.close();
        
    }
}
