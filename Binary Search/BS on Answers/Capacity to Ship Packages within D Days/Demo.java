import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static boolean valid(int[] weights, int days, int maxload) {
        int load = 0;
        for(int wt: weights) {
            if(wt > maxload) return false;

            load += wt;
            if(load > maxload) {
                if(--days <= 0) return false;
                load = wt;
            }
        }
        return true;
    }
    
    public static int leastWeightCapacity(int[] weights, int days) {
        int mini = 500;
        int maxi = 0;
        for(int wt: weights) {
            mini = Math.min(days, mini);
            maxi += wt;
        }

        if(days == 1) return maxi;

        int lb = mini;
        int ub = maxi;
        int mid;

        while(lb <= ub) {
            mid = (lb + ub) / 2;
            if(valid(weights, days, mid)) ub = mid - 1;
            else lb = mid + 1;
        }
        return lb;
    }
    
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int days = input.nextInt();

        int[] weights = new int[n];
        for(int i = 0; i < n; ++i)
            weights[i] = input.nextInt();

        int res = leastWeightCapacity(weights, days);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
