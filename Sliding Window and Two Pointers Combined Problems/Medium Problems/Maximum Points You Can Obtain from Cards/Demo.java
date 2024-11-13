import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;

        for(int i = 0; i < k; ++i) {
            sum += cardPoints[i];
        }

        if (k == n)
            return sum;
        int maxi = sum;
        int right = n - 1;

        for (int left = k - 1; left >= 0; --left) {
            sum = sum - cardPoints[left] + cardPoints[right--];
            maxi = Math.max(maxi, sum);
        }
        return maxi;
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int k = input.nextInt();

        int[] nums = new int[N];
        for (int i = 0; i < N; ++i)
            nums[i] = input.nextInt();

        System.out.println(-1 % 7);

        int res = maxScore(nums, k);

        output.write(res + "");

        input.close();
        output.close();
    }
}
