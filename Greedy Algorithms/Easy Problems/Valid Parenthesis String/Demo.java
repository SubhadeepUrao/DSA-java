import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static boolean solve(char[] arr, int i, int cnt) {
        if (cnt < 0)
            return false;
        if (i == arr.length)
            return cnt == 0;

        if (arr[i] == '(')
            return solve(arr, i + 1, cnt + 1);
        if (arr[i] == ')')
            return solve(arr, i + 1, cnt - 1);

        return solve(arr, i + 1, cnt + 1) ||
                solve(arr, i + 1, cnt - 1) ||
                solve(arr, i + 1, cnt);
    }

    public static boolean checkValidString(String s) {
        char[] arr = s.toCharArray();
        return solve(arr, 0, 0);
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        String str = input.next();

        boolean res = checkValidString(str);
        
        output.write(Boolean.toString(res));
        
        input.close();
        output.close();
    }
}