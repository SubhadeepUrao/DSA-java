import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int numOfSubstringLessThanEqualDistinctLettersK(String s, int goal) {
        int[] mpp = new int[3];
        int left = 0;
        int cnt = 0;
        int distinct = 0;
        int n = s.length();
        char[] str = s.toCharArray();

        for(int right = 0; right < n; ++right) {
            // int ch = s.charAt(right) - 97;
            int ch = str[right] - 97;
            if(mpp[ch] == 0) {
                ++distinct;
            }
            mpp[ch]++;

            while (distinct > goal) {
                // int leftChar = s.charAt(left) - 97;
                int leftChar = str[left] - 97;
                mpp[leftChar]--;
                if(mpp[leftChar] == 0) --distinct;
                ++left;
            }
            cnt += right - left + 1;
        }
        return cnt;
    }

    public static int numberOfSubstrings(String s) {
        return numOfSubstringLessThanEqualDistinctLettersK(s, 3) -
                numOfSubstringLessThanEqualDistinctLettersK(s, 2);
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();

        int res = numberOfSubstrings(s);

        output.write(res + "");

        input.close();
        output.close();
    }
}