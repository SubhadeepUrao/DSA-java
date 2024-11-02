import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    
    public static boolean searchRotatedArrayII(int[] nums, int target) {
        int lb = 0;
        int ub = nums.length - 1;
        int mid;
        while(lb <= ub) {
            mid = (lb + ub) / 2;
            if(nums[mid] == target) return true;
            else if(nums[lb] == nums[mid] && nums[mid] == nums[ub]) {
                lb++;
                ub--;
            }
            else if(nums[mid] <= nums[ub]) {
                if(nums[mid] < target && target <= nums[ub]) lb = mid + 1;
                else ub = mid - 1;
            }
            else {
                if(nums[lb] <= target && target < nums[mid]) ub = mid - 1;
                else lb = mid + 1;
            }
        }
        return false;
    }
    
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int size = input.nextInt();
        int x = input.nextInt();
        
        int[] arr = new int[size];
        for(int i = 0; i < size; ++i) {
            arr[i] = input.nextInt();
        }

        boolean res = searchRotatedArrayII(arr, x);

        output.write(Boolean.toString(res));

        input.close();
        output.close();
        
    }
}
