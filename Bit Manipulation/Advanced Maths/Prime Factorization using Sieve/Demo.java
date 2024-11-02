import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void sieve(int[] prime, int N) {
        for(int i = 2; i <= N; ++i)
            prime[i] = i;
        
        // N loglog N
        // store smallest prime factors of a number (SPF)
        for(int i = 2; i*i <= N; ++i) {
            if(prime[i] == i)
                for(int j = i*i; j <= N; j += i) {
                    if(i < prime[j]) prime[j] = i;
                }
        }
    }
    public static List<Integer> findPrimeFactors(int N) {
        int[] prime = new int[N+1];

        sieve(prime, N);

        List<Integer> list = new ArrayList<>();

        // log N base2 => worst case: when N is in power of 2
        while(N != 1) {
            list.add(prime[N]);
            N /= prime[N];
        }
        return list;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();

        List<Integer> res = findPrimeFactors(N);

        output.write(res.toString());

        input.close();
        output.close();
    }
}