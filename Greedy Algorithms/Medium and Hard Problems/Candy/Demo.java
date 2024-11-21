import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];

        left[0] = 1;

        for(int i = 1; i < n; ++i) {
            if(ratings[i-1] < ratings[i])
                left[i] = left[i - 1] + 1;
            else
                left[i] = 1;
        }
        int cnt = left[n-1];
        for(int i = n-2; i >= 0; --i) {
            if(ratings[i] > ratings[i+1])
                left[i] = Math.max(left[i], left[i + 1] + 1);

            cnt += left[i];
        }
        return cnt;
    }

    // public int candy(int[] ratings) {
    //     int n = ratings.length;
    //     int[] left = new int[n];
    //     int[] right = new int[n];

    //     left[0] = 1;
    //     right[n-1] = 1;

    //     for(int i = 1; i < n; ++i) {
    //         if(ratings[i-1] < ratings[i])
    //             left[i] = left[i - 1] + 1;
    //         else
    //             left[i] = 1;
    //     }
    //     for(int i = n-2; i >= 0; --i) {
    //         if(ratings[i] > ratings[i+1])
    //             right[i] = right[i + 1] + 1;
    //         else
    //             right[i] = 1;
    //     }
    //     int cnt = 0;
    //     for(int i = 0; i < n; ++i) {
    //         cnt += Math.max(left[i], right[i]);
    //     }
    //     return cnt;
    // }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i)
            nums[i] = input.nextInt();
        
        int res = candy(nums);
        
        output.write(Integer.toString(res));
        
        input.close();
        output.close();
    }
}