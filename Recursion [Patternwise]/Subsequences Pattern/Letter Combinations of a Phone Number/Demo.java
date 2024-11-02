import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void gen(List<String> list, char[] sublist, HashMap<Character, String> mpp, String s, int level, int ht) {
        if(level == ht) {
            list.add(String.valueOf(sublist));
            return;
        }

        String str = mpp.get(s.charAt(level));
        int n = str.length();
        for(int i = 0; i < n; ++i) {
            sublist[level] = str.charAt(i);
            gen(list, sublist, mpp, s, level+1, ht);
        }
    }
    public static List<String> letterCombinations(String digits) {
        int n = digits.length();
        if(n == 0) return new ArrayList<>();

        HashMap<Character, String> mpp = new HashMap<>();
        mpp.put('2', "abc");
        mpp.put('3', "def");
        mpp.put('4', "ghi");
        mpp.put('5', "jkl");
        mpp.put('6', "mno");
        mpp.put('7', "pqrs");
        mpp.put('8', "tuv");
        mpp.put('9', "wxyz");

        if(n == 1) return new ArrayList<>(Arrays.asList(mpp.get(digits.charAt(0)).split("")));

        List<String> list = new ArrayList<>();
        gen(list, new char[n], mpp, digits, 0, n);
        return list;
    }

    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String digits = input.next();

        String res = letterCombinations(digits).toString();

        output.write(res);

        input.close();
        output.close();
    }
}
