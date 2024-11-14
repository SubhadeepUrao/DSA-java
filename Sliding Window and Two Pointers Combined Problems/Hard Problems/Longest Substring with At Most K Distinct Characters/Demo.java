import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int kDistinctChars(int k, String str) {
		int[] mpp = new int[26];
		int left = 0;
		int maxi = 0;
		int n = str.length();
		int distinct = 0;

		for (int right = 0; right < n; ++right) {
            int ch = str.charAt(right) - 97;
            if (mpp[ch] == 0) {
                ++distinct;
            }
            mpp[ch]++;
            if (distinct > k) {
                int leftCh = str.charAt(left) - 97;
                mpp[leftCh]--;
                if (mpp[leftCh] == 0)
                    --distinct;
                ++left;
            } else
                maxi = Math.max(maxi, right - left + 1);
        }
        return maxi;
	}
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int k = input.nextInt();
        String s = input.next();

        int res = kDistinctChars(k, s);

        output.write(res + "");

        input.close();
        output.close();
    }
}