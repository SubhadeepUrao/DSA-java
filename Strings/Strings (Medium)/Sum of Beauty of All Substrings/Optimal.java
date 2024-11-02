import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Optimal {

    public static int beautySum(String s) {
        final int C = 26;
        final int N = s.length();
        final char[] chars = s.toCharArray();

        int[] freq = new int[C];     // freq[ch-'a'] = frequency of ch in current substring
        int[] histo = new int[N+1];  // histo[f] = number of chars with frequency f; 1<=f<=N.

        int sum=0;
        for(int i=0; i<N; i++)
        {
            int min = 0, max = 0;
            Arrays.fill(freq, 0);
            // histo[f] is zeroed when f is reached

            for(int j=i; j<N; j++)
            {
                char ch = chars[j];
                int f = ++freq[ch-'a'];

                if(f>max)
                    histo[max = f] = 0; // zero new histo slot
                ++histo[f];

                if(f==1 || --histo[f-1]==0 && f-1==min )
                    min = f;

                sum += (max-min);
            }
        }
        return sum;
    }
    public static void main(String args[]) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();

        int res = beautySum(s);

        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}