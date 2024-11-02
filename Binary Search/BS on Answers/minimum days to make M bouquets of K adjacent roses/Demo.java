import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static boolean valid(int[] roses, int minDays, int K, int M) {
        int cnt = 0;
        int bouquets = 0;
        for(int bloomDays: roses) {
            if(bloomDays <= minDays)
                cnt++;
            else {
                bouquets += cnt / K;
                cnt = 0;
            }
        }
        bouquets += cnt / K;
        return bouquets >= M;
    }
    
    public static int roseroses(int[] roses, int K, int M) {
        if(M*K > roses.length) return -1;

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int bloomDays: roses) {
            mini = Math.min(mini, bloomDays);
            maxi = Math.max(maxi, bloomDays);
        }

        int lb = mini;
        int ub = maxi;
        int mid;

        while(lb <= ub) {
            mid = (lb + ub) / 2;
            if(valid(roses, mid, K, M)) ub = mid - 1;
            else lb = mid + 1;
        }
        return lb;
    }
    
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] roses = new int[n];
        for(int i = 0; i < n; ++i)
            roses[i] = input.nextInt();
        
        int K = input.nextInt();
        int M = input.nextInt();

        int res = roseroses(roses, K, M);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
