import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Brute {

    public static double minimiseMaxDistance(int[] gasStations, int k) {
        int n = gasStations.length;
        int[] sector = new int[n-1];
        
        double maxi;
        while(k != 0) {
            maxi = 0;
            int maxIndex = 0;
            for(int i = 0; i < n-1; ++i) {
                int diff = gasStations[i+1] - gasStations[i];
                double sectionLength = diff / (double)(sector[i]+1);
                if(maxi < sectionLength) {
                    maxi = sectionLength;
                    maxIndex = i;
                }
            }
            sector[maxIndex]++;
            --k;
        }

        maxi = 0;
        for(int i = 1; i < n; ++i) {
            int diff = gasStations[i] - gasStations[i-1];
            double sectionLength = diff / (double)(sector[i-1] + 1);
            if(maxi < sectionLength) maxi = sectionLength;
        }


        return maxi;
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
