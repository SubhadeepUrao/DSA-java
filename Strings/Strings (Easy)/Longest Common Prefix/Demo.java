import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static String longestCommonPrefix(String[] strs) {
        boolean flag = true;
        int n = strs.length;
        int[] len = new int[n];
        int i;
        for(i = 0; i < n; ++i) {
            len[i] = strs[i].length();
        }

        for(i = 0; i < len[0]; ++i) {
            char ch = strs[0].charAt(i);
            for(int j = 1; j < n; ++j) {
                if(i < len[j] && ch == strs[j].charAt(i)) {}
                else {
                    flag = false;
                    break;
                }
            }
            if(!flag) break;
        }
        return strs[0].substring(0,i);
    }
    public static void main(String args[]) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int cnt = 0;
        while(input.hasNext()) {
            input.next();
            cnt++;
        }
        input.close();
        input = new Scanner(inputfile);
        String[] strs = new String[cnt];

        for(int i = 0; i < cnt; ++i) {
            strs[i] = input.next();
        }

        String res = longestCommonPrefix(strs);

        output.write(res);

        input.close();
        output.close();
    }
}