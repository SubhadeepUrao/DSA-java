import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static boolean valid(int[] nums, int k, int maxSum) {
        int sum = 0;
        for(int elem: nums) {
            if(elem > maxSum) return false;
            sum += elem;
            if(sum > maxSum) {
                --k;
                sum = elem;
            }
        }
        --k;
        if(k >= 0) return true;
        return false;
    }

    public static int largestSubarraySumMinimized(int[] nums, int k) {
        int mini = 0;
        int maxi = 0;
        for(int elem: nums) {
            mini = Math.max(mini, elem);
            maxi += elem;
        }
        
        int lb = mini;
        int ub = maxi;
        int mid;

        while(lb <= ub) {
            mid = (lb + ub) / 2;
            if(valid(nums, k, mid)) ub = mid - 1;
            else lb = mid + 1;
        }
        return lb;
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        int[] nums = new int[n];
        for(int i = 0; i < n; ++i) {
            nums[i] = input.nextInt();
        }

        int k = input.nextInt();

        int res = largestSubarraySumMinimized(nums, k);

        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}