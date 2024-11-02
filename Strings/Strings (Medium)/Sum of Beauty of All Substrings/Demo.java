import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int getBeauty(int[] freq) {
        int maxi = 0;
        int mini = 500;
        for(int i = 0; i < 26; ++i) {
            if(maxi < freq[i]) maxi = freq[i];
            if(freq[i] != 0 && mini > freq[i]) mini = freq[i];
        }
        return maxi < mini ? 0: maxi - mini;
    }

    public static int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        for(int i = 0; i < n; ++i) {
            int[] freq = new int[26];
            for(int j = i; j < n; ++j) {
                ++freq[s.charAt(j)-97];
                sum += getBeauty(freq);
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