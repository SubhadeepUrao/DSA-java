import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    
    public static int totalHours(int[] piles, int mid) {
        // if(mid == 1) return 1_000_000_001;
        double total = 0;
        for(int pile: piles) {
            total += (pile + mid - 1) / mid;
        }
        return (int)total;
    }
    public static int minimumRateToEatBananas(int []piles, int h) {
        int maxi = 0;
        for(int pile: piles)
            maxi = Math.max(maxi, pile);

        int lb = 1;
        int ub = maxi;
        int totalhours;
        int mid;

        while(lb <= ub) {
            mid = (lb + ub) / 2;
            totalhours = totalHours(piles, mid);
            if(totalhours <= h) ub = mid - 1;
            else lb = mid + 1;
        }

        return lb;
    }
    
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] piles = new int[n];
        for(int i = 0; i < n; ++i)
            piles[i] = input.nextInt();
        
        int h = input.nextInt();

        int res = minimumRateToEatBananas(piles, h);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
