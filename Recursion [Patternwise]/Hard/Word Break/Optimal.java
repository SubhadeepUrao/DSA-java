import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Optimal {

    // memo[i] = 1 means s[0...i] can be segmented.
    // memo[i] = 0 means s[0...i] cannot be segmented.

    public static boolean canBreak(String s, List<String> wordDict, int[] memo, int i) {
        if(i < 0) return true;

        if(memo[i] != -1) return memo[i] == 1;

        for(String word: wordDict) {
            if(i - word.length() + 1 < 0) continue;

            if (s.substring(i - word.length() + 1, i + 1).equals(word)
                    && canBreak(s, wordDict, memo, i - word.length())) {
                memo[i] = 1;
                return true;
            }
        }
        memo[i] = 0;
        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return canBreak(s, wordDict, memo, s.length() - 1);
    }
    
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
