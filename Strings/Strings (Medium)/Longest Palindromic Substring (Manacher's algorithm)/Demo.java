import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


// Manacher's algorithm
public class Demo {
    public static StringBuilder includeHash(String s) {
        StringBuilder str = new StringBuilder();
        str.append("#");
        int n = s.length();
        for(int i = 0; i < n; ++i) {
            str.append(s.charAt(i));
            str.append('#');
        }
        return str;
    }
    public static String removeHash(String s) {
        StringBuilder str = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if(ch != '#')
                str.append(ch);
        }
        return str.toString();
    }
    
    public static String longestPalindrome(String s) {

        StringBuilder str = includeHash(s);
        int n = str.length();
        int[] len = new int[n];
        Arrays.fill(len, 1);

        int left = 1;
        int right = 1;
        // left and right are exclusive boundary limits

        for(int i = 1; i < n; ++i) {
            // copying previously calculated data, mirror fanda within a boundary that is palindrome
            if(left + right - i >= 0)
                len[i] = Math.max(1, Math.min(right - i, len[left + right - i]));

            while(i+len[i] < n && i-len[i] >= 0 && str.charAt(i + len[i]) == str.charAt(i - len[i]))
                len[i]++;

            // set new boundary
            if(i + len[i] > right) {
                left = i - len[i];
                right = i + len[i];
            }
        }

        int maxi = len[0];
        int maxiPos = 0;
        for(int i = 1; i < n; ++i) {
            if(maxi < len[i]) {
                maxi = len[i];
                maxiPos = i;
            }
        }

        // Arrays.stream(len).forEach(num -> System.out.print(num+" "));

        return removeHash(str.substring(maxiPos - maxi+1, maxiPos + maxi));

    }
    public static void main(String args[]) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();

        String res = longestPalindrome(s);

        output.write(res);

        input.close();
        output.close();
    }
}