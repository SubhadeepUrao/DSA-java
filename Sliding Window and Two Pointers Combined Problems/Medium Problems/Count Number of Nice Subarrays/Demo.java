import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    // problem is same as Binary subarray with sum, just require slight changes

    public static int numSubarrayWithSumLessThanEqual(int[] nums, int goal) {
        if (goal < 0)
            return 0;

        int left = 0;
        int n = nums.length;
        int sum = 0;
        int cnt = 0;

        for (int right = 0; right < n; ++right) {
            sum += nums[right] % 2;

            while (sum > goal) {
                sum -= nums[left++] % 2;
            }
            cnt += right - left + 1;
        }
        return cnt;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarrayWithSumLessThanEqual(nums, goal) - numSubarrayWithSumLessThanEqual(nums, goal - 1);
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        return numSubarraysWithSum(nums, k);
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

        int res = numberOfSubarrays(nums, goal);

        output.write(res + "");

        input.close();
        output.close();
    }
}
