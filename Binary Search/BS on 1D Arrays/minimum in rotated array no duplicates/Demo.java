import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    
    public static int minRotatedArray(int[] nums) {
        int lb = 0;
        int ub = nums.length - 1;
        int mid;
        int mini = Integer.MAX_VALUE;

        while(lb <= ub) {
            if(nums[lb] < nums[ub]) { // little optimization
                mini = Math.min(mini, nums[lb]);
                break;
            }

            mid = (lb + ub) / 2;
            if(nums[lb] <= nums[mid]) { // left part is sorted
                mini = Math.min(mini, nums[lb]);
                lb = mid + 1;
            }
            else { // right part is sorted
                mini = Math.min(mini, nums[mid]);
                ub = mid - 1;
            }
        }
        return mini;
    }
    
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int size = input.nextInt();
        // int x = input.nextInt();
        
        int[] arr = new int[size];
        for(int i = 0; i < size; ++i) {
            arr[i] = input.nextInt();
        }

        int res = minRotatedArray(arr);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
