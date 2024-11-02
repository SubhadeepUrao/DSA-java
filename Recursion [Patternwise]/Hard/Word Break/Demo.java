import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static boolean solve(String s, List<String> wordDict, int ind) {
        int n = s.length();

        if(ind == n) return true;

        String str = "";
        for(int i = ind; i < n; ++i) {
            str += s.charAt(i);
            if(wordDict.contains(str)) {
                if(solve(s, wordDict, i+1)) return true;
            }
        }
        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return solve(s, wordDict, 0);
    }

    // public static void solve(String s, List<String> wordDict, boolean[] dp, int ind, int n) {
    //     if(ind < 0) return;

    //     for(String word: wordDict) {
    //         int lastExclusive = ind + word.length();
    //         if(lastExclusive <= n && s.substring(ind, lastExclusive).equals(word)) {
    //             dp[ind] = dp[lastExclusive];
    //             solve(s, wordDict, dp, ind-1, n);
    //         }
    //         if(dp[ind]) return;
    //     }
    //     solve(s, wordDict, dp, ind-1, n);
    // }

    // public static boolean wordBreak(String s, List<String> wordDict) {
    //     int n = s.length();
    //     boolean[] dp = new boolean[n + 1];
    //     dp[n] = true;

    //     solve(s, wordDict, dp, n-1, n);
    //     return dp[0];
    // }

    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();
        List<String> wordDict = new ArrayList<>();
        while(input.hasNext()) {
            wordDict.add(input.next());
        }

        boolean res = wordBreak(s, wordDict);

        output.write(res + "");

        input.close();
        output.close();
        
    }
}
