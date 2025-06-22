import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static boolean valid(int[] boards, int k, int maxLength) {
        int total = 0;
        for(int length: boards) {
            if(length > maxLength) return false;
            total += length;
            if(total > maxLength) {
                --k;
                total = length;
            }
        }
        --k;
        if(k >= 0) return true;
        return false;
    }

    public static int paintersPartition(int[] boards, int k) {
        int mini = 0;
        int maxi = 0;
        for(int length: boards) {
            mini = Math.max(mini, length);
            maxi += length;
        }

        int lb = mini;
        int ub = maxi;
        int mid;

        while(lb <= ub) {
            mid = (lb + ub) / 2;
            if(valid(boards, k, mid)) ub = mid - 1;
            else lb = mid + 1;
        }
        return lb;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int k = input.nextInt();

        int[] boards = new int[n];
        for(int i = 0; i < n; ++i)
            boards[i] = input.nextInt();

        int res = paintersPartition(boards, k);

        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}