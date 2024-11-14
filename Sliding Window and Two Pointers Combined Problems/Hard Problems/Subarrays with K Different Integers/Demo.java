import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int subarraysWithAtmostKDistinct(int[] nums, int k) {
        if(k < 0) return 0;
        int n = nums.length;
        int[] mpp = new int[n+1];
        int left = 0;
        int cnt = 0;
        int distinct = 0;

        for(int right = 0; right < n; ++right) {
            if(mpp[nums[right]] == 0) ++distinct;
            ++mpp[nums[right]];

            while (distinct > k) {
                --mpp[nums[left]];
                if(mpp[nums[left]] == 0) --distinct;
                ++left;
            }

            cnt += right - left + 1;
        }
        return cnt;
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithAtmostKDistinct(nums, k) - subarraysWithAtmostKDistinct(nums, k-1);
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int K = input.nextInt();

        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();

        int res = subarraysWithKDistinct(nums, K);

        output.write(res + "");

        input.close();
        output.close();
    }
}
