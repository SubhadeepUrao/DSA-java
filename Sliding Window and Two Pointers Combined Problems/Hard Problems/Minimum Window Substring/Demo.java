import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static String minWindow(String s, String t) {
        int[] mpp = new int[128];
        int n = t.length();
        int m = s.length();
        int left = 0;
        int cnt = 0;
        char[] str = s.toCharArray();
        int start = 0;
        int end = 0;

        for(int i = 0; i < n; ++i)
            mpp[t.charAt(i)]++;

        for(int right = 0; right < m; ++right) {
            if(mpp[str[right]] > 0) cnt++;
            mpp[str[right]]--;

            while (cnt == n) {
                mpp[str[left]]++;
                if(mpp[str[left]] > 0) {
                    --cnt;
                    if(end == 0 || end - start > right - left + 1) {
                        start = left;
                        end = right + 1;
                    }
                }
                left++;
            }
        }

        return end > 0 ? s.substring(start, end) : "";
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();
        String t = input.next();

        String res = minWindow(s, t);

        output.write(res);

        input.close();
        output.close();
    }
}