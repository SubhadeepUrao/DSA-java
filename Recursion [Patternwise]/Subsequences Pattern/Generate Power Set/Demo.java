import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static List<List<Integer>> gen(List<List<Integer>> list, List<Integer> sublist, int i, int n, int[] nums) {
        if(i == n) return list;

        while(i < n) {
            // sublist.add(nums[i]);
            // list.add(new ArrayList<>(sublist));
            // gen(list, sublist, ++i, n, nums);
            // sublist.remove(sublist.size()-1);
            List<Integer> templist = new ArrayList<>(sublist);
            templist.add(nums[i]);
            list.add(templist);
            gen(list, templist, ++i, n, nums);
        }
        return list;
    }
    public static List<List<Integer>> genPowerSet(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // List<List<Integer>> list = new ArrayList<>();
        // list.add(List.of());
        list.add(Collections.emptyList());

        return gen(list, new ArrayList<>(), 0, nums.length, nums);

    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        int[] nums = new int[n];
        for(int i = 0; i < n; ++i)
            nums[i] = input.nextInt();

        String res = genPowerSet(nums).toString();

        output.write(res);

        input.close();
        output.close();
        
    }
}
