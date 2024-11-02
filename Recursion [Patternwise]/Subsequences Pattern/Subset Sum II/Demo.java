import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void gen(List<List<Integer>> list, List<Integer> sublist, int ind, int[] nums) {
        
        list.add(new ArrayList<>(sublist));

        if(ind == nums.length) {
            return;
        }

        for(int i = ind; i < nums.length; ++i) {
            if(i == ind || nums[i] != nums[i-1]) {
                sublist.add(nums[i]);
                // list.add(new ArrayList<>(sublist));
                gen(list, sublist, i+1, nums);
                sublist.remove(sublist.size() - 1);
            }
        }
    }
    public static List<List<Integer>> subsetSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        gen(list, new ArrayList<>(), 0, nums);
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
