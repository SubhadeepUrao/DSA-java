import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Demo {
    
    static int[] replaceWithRank(int arr[], int N) {
        
        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = arr[i];
            
        Arrays.sort(nums);
        
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int rank = 1;
        
        for(int i = 0; i < N; ++i) {
            if(!mpp.containsKey(nums[i]))
                mpp.put(nums[i], rank++);
        }
        for(int i = 0; i < N; ++i)
            nums[i] = mpp.get(arr[i]);
            
        return nums;
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();

        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();
        
        int[] res = replaceWithRank(nums, N);
        
        output.write(Arrays.toString(res));
        
        input.close();
        output.close();
    }
}