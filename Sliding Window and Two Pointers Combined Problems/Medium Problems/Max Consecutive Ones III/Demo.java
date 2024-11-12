import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int longestOnes(int[] nums, int k) {
        int lives = k;
        int left = 0;
        int maxi = 0;
        int n = nums.length;
        int[] zeros = new int[n];
        int front = 0;
        int rear = 0;

        for(int right = 0; right < n; ++right) {
            if(nums[right] == 0) {
                zeros[rear++] = right + 1;
                if(lives == 0) {
                    maxi = Math.max(maxi, right - left);
                    left = zeros[front++];
                }
                else --lives;
            }
        }
        return Math.max(maxi, n - left);
    }

    // public static int longestOnes(int[] nums, int k) {
    //     int lives = k;
    //     int left = 0;
    //     int maxi = 0;
    //     int n = nums.length;
    //     Deque<Integer> list = new ArrayDeque<>();

    //     for(int right = 0; right < n; ++right) {
    //         if(nums[right] == 0) {
    //             list.add(right + 1);
    //             if(lives > 0) --lives;
    //             else {
    //                 maxi = Math.max(maxi, right - left);
    //                 left = list.remove();
    //             }
    //         }
    //     }
    //     return Math.max(maxi, n - left);
    // }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int k = input.nextInt();

        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();

        int res = longestOnes(nums, k);

        output.write(res + "");

        input.close();
        output.close();
    }
}
