import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Demo {

    public static String reverseWords(String s) {
        char[] ch = s.toCharArray();
        LinkedList<StringBuilder> res = new LinkedList<>();
        StringBuilder word = new StringBuilder();
        boolean wordSet = false;
        int n = s.length();
        // int cnt = 0;
        for(int i = 0; i < n; ++i) {
            if(ch[i] != ' ') {
                word.append(ch[i]);
                wordSet = true;
                // ++cnt;
            }
            else {
                if(wordSet) {
                    word.append(' ');
                    res.addFirst(word);
                    wordSet = false;
                    word = new StringBuilder();
                    // ++cnt;
                }
            }
        }
        if(wordSet) {
            word.append(' ');
            res.addFirst(word);
            word = new StringBuilder();
            // ++cnt;
        }

        for(StringBuilder str: res) {
            word.append(str);
        }
        // word.setLength(cnt-1);

        // return word.toString();
        return word.toString().trim();
    }
    public static void main(String args[]) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String s = input.nextLine();

        String res = reverseWords(s);

        output.write(res);

        input.close();
        output.close();
    }
}