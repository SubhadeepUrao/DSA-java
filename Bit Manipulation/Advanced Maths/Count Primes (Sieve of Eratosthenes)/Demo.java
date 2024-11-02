import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    // N log log N => prime harmonic series
    public static int countPrimes(int n) {
        boolean[] prime = new boolean[n+1];

        for(int i = 2; i*i <= n; ++i) {
            if(!prime[i]) {
                for(int j = i*i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        int cnt = 0;
        for(int i = 2; i < n; ++i) {
            if(!prime[i]) ++cnt;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        int res = countPrimes(n);
        
        output.write(res + "");

        input.close();
        output.close();
    }
}