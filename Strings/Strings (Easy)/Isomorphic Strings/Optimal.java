import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
// import java.util.HashSet;
import java.util.Scanner;

public class Optimal {

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mpp = new HashMap<>();
        // HashSet<Character> hs = new HashSet<>();
        boolean[] mapped = new boolean[256];

        int slen = s.length();
        int tlen = t.length();

        if(slen != tlen) return false;

        for(int i = 0; i < slen; ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if(!mpp.containsKey(sChar)) {
                if(mapped[tChar]) return false;
                else {
                    mpp.put(sChar, tChar);
                    // hs.add(tChar);
                    mapped[tChar] = true;
                }
            }
            else {
                if(mpp.get(sChar) != tChar) return false;
            }
        }
        return true;
    }
    public static void main(String args[]) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.next();
        String t = input.next();

        boolean res = isIsomorphic(s, t);

        output.write(Boolean.toString(res));

        input.close();
        output.close();
    }
}