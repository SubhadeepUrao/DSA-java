import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void gen(List<List<Integer>> list, List<Integer> sublist, int i, int count, int k, int target, int[] nums) {
        if(count == k) {
            if(target == 0) list.add(new ArrayList<>(sublist));
            return;
        }
        if(i == nums.length) return;
        if(nums[i] <= target) {
            sublist.add(nums[i]);
            gen(list, sublist, i+1, count+1, k, target-nums[i], nums);
            sublist.remove(count);
        }
        gen(list, sublist, i+1, count, k, target, nums);
    }
    public static List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        gen(list, new ArrayList<>(), 0, 0, k, target, nums);
        return list;
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int k = input.nextInt();
        int n = input.nextInt(); // target

        String res = combinationSum3(k, n).toString();

        output.write(res);

        input.close();
        output.close();
        
    }
}
