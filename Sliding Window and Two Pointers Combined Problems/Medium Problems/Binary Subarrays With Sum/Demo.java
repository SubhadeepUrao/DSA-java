import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    // promblem is same as count subarray sum equals k
    // here we don't use auxiliary space as it was use in "subarray sum equals k" i.e. HashMap

    public static int numSubarrayWithSumLessThanEqual(int[] nums, int goal) {
        if(goal < 0) return 0;

        int left = 0;
        int n = nums.length;
        int sum = 0;
        int cnt = 0;

        for(int right = 0; right < n; ++right) {
            sum += nums[right];

            while(sum > goal) {
                sum -= nums[left++];
            }
            cnt += right - left + 1;
        }
        return cnt;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarrayWithSumLessThanEqual(nums, goal) - numSubarrayWithSumLessThanEqual(nums, goal-1);
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int goal = input.nextInt();

        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();

        int res = numSubarraysWithSum(nums, goal);

        output.write(res + "");

        input.close();
        output.close();
    }
}
