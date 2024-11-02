import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    
    public static int lowerBound(int[] nums, int x) {
        int lb = 0;
        int ub = nums.length - 1;
        int mid;
        while(lb <= ub) {
            mid = (lb + ub) / 2;
            if(x <= nums[mid]) ub = mid - 1;
            else lb = mid + 1;
        }
        return lb;
    }
    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return new int[] {-1, -1};

        int first = lowerBound(nums, target);
        
        if(first == n || target != nums[first]) return new int[] {-1, -1};

        int second = lowerBound(nums, target+1) - 1;

        return new int[] {first, second};
    }
    public static int count(int nums[], int x) {
        int[] res = searchRange(nums, x);
        return res[0] == -1 ? 0 : res[1] - res[0] + 1;
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

        int res = count(arr, x);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
