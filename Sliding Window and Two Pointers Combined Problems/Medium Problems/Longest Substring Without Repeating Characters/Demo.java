import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int[] mpp = new int[128];
        int left = 0;
        int maxi = 0;

        for (int right = 0; right < n; ++right) {
            int ch = s.charAt(right);
            left = Math.max(left, mpp[ch]);
            mpp[ch] = right + 1;
            maxi = Math.max(maxi, right - left + 1);
        }
        return maxi;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();

        int res = lengthOfLongestSubstring(s);

        output.write(res + "");

        input.close();
        output.close();
    }
}