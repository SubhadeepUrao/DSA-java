import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static String minWindow(String S, String T) {
        int n = S.length();
        int m = T.length();
        int left = 0, start = 0, end = 0;
        int j = 0;

        for (int right = 0; right < n; ++right) {
            if (S.charAt(right) == T.charAt(j)) {
                j++;
                if (j == m) {
                    // Backtrack to find the start of the current valid window
                    left = right - 1;
                    j = m - 2;
                    while (j >= 0) {
                        if (S.charAt(left) == T.charAt(j))
                            j--;
                        left--;
                    }
                    left++; // Adjust to the correct start position

                    if (end == 0 || end - start > right - left + 1) {
                        start = left;
                        end = right + 1;
                    }

                    right = left;
                    j = 0; // Reset for finding the next sequence
                }
            }
        }
        return end > 0 ? S.substring(start, end) : "";
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