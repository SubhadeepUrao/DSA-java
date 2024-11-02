import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal {
    public static boolean valid(int[] gasStations, int k, double maxDist) {
        int n = gasStations.length;
        int cnt = 0;
        for(int i = 0; i < n-1; ++i) {
            int diff = gasStations[i+1] - gasStations[i];
            int numbersInBetween = (int)(diff / maxDist);

            if(diff == numbersInBetween * maxDist) --numbersInBetween;

            cnt += numbersInBetween;
        }
        if(cnt > k) return true;
        return false;
    }

    public static double minimiseMaxDistance(int[] gasStations, int k) {
        int n = gasStations.length;
        double lb = 0;
        double ub = 0;

        for(int i = 1; i < n; ++i) {
            ub = Math.max(gasStations[i] - gasStations[i-1], ub);
        }

        double mid;
        double diff = 1e-6;

        while(ub - lb > diff) {
            mid = (lb + ub) / 2;
            if(valid(gasStations, k, mid)) lb = mid;
            else ub = mid;
        }
        return ub;
    }

    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int k = input.nextInt();

        int[] gasStations = new int[n];
        for(int i = 0; i < n; ++i)
            gasStations[i] = input.nextInt();

        double res = minimiseMaxDistance(gasStations, k);

        output.write(Double.toString(res));

        input.close();
        output.close();
        
    }
}
