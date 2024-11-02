import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static int findSubstringCount(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int cnt = 0;
        int substringCnt = 0;

        int left = 0;
        int right = 0;
        for(left = 0; left < n; ++left ) {
            while(right < n && cnt < k) {
                freq[s.charAt(right)-97]++;
                if(freq[s.charAt(right)-97] == 1) cnt++;
                right++;
            }
            if(cnt == k) {
                substringCnt += n - right + 1;
            }
            freq[s.charAt(left)-97]--;
            if(freq[s.charAt(left)-97] == 0) cnt--;
        }
        return substringCnt;    
    }
    public static int substrCount(String s, int k) {
        return findSubstringCount(s, k) - findSubstringCount(s, k+1);
    }
    public static void main(String args[]) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();
        int k = input.nextInt();

        int res = substrCount(s, k);

        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}