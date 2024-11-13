import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal {
    static {
        // reduces runtime in leetcode
        for (int i = 0; i < 500; i++) {
            characterReplacement("", 1);
        }
    }

    public static int characterReplacement(String s, int k) {
        int[] mpp = new int[26];
        int left = 0;
        int maxi = 0;
        int n = s.length();
        int maxf = 0;

        for(int right = 0; right < n; ++right) {
            int ch = s.charAt(right) - 65;
            mpp[ch]++;
            maxf = Math.max(maxf, mpp[ch]);
            if(right - left + 1 - maxf > k) {
                mpp[s.charAt(left) - 65]--;
                left++;
            }
            else
                maxi = Math.max(maxi, right - left + 1);
        }
        return maxi;
    }

    // public static int characterReplacement(String s, int k) {
    //     int[] mpp = new int[26];
    //     int left = 0;
    //     int maxi = 0;
    //     int n = s.length();
    //     int maxf = 0;

    //     for(int right = 0; right < n; ++right) {
    //         int ch = s.charAt(right) - 65;
    //         mpp[ch]++;
    //         maxf = Math.max(maxf, mpp[ch]);
    //         if(right - left + 1 - maxf > k) {
    //             mpp[s.charAt(left) - 65]--;
    //             left++;
    //         }
    //         maxi = Math.max(maxi, right - left + 1);
    //     }
    //     return maxi;
    // }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();
        int k = input.nextInt();

        int res = characterReplacement(s, k);

        output.write(res + "");

        input.close();
        output.close();
    }
}