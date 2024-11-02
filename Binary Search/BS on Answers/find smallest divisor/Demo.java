import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int valid(int[] nums, int mid) {
        int sum = 0;
        for(int elem: nums)
            sum += (elem + mid - 1) / mid;
        
        return sum;
    }
    public static int smallestDivisor(int[] nums, int limit) {
        if(nums.length > limit) return -1;
        int maxi = 0;
        for(int elem: nums) maxi = Math.max(maxi, elem);

        int lb = 1;
        int ub = maxi;
        int mid;

        while(lb <= ub) {
            mid = (lb + ub) / 2;
            if(valid(nums, mid) <= limit) ub = mid - 1;
            else lb = mid + 1;
        }
        return lb;
    }
    
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i)
            nums[i] = input.nextInt();
        
        int limit = input.nextInt();

        int res = smallestDivisor(nums, limit);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
