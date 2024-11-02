import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static boolean isPalindrome(String str, int left, int right) {
        while(left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            ++left;
            --right;
        }
        return true;
    }
    public static void gen(List<List<String>> list, List<String> sublist, int ind, String str) {
        if(ind == str.length()) {
            list.add(new ArrayList<>(sublist));
            return;
        }
        int len = str.length();
        for (int i = ind; i < len; ++i) {
            if(isPalindrome(str, ind, i)) {   // ["" | "abc"]
                sublist.add(str.substring(ind, i + 1));
                gen(list, sublist, i + 1, str);
                sublist.remove(sublist.size() - 1);
            }
        }
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        gen(list, new ArrayList<>(), 0, s);
        return list;
    }

    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String str = input.next();

        String res = partition(str).toString();

        output.write(res);

        input.close();
        output.close();
        
    }
}
