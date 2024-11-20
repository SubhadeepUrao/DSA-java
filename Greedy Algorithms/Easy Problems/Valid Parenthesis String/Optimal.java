import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal {
    public static boolean checkValidString(String s) {
        char[] arr = s.toCharArray();
        int min = 0;
        int max = 0;

        for(char ch : arr) {
            if(ch == '(') {
                min = min + 1;
                max = max + 1;
            }
            else if(ch == ')') {
                min = min - 1;
                max = max - 1;
            }
            else {
                min = min - 1;
                max = max + 1;
            }
            if(min < 0) min = 0;
            if(max < 0) return false;
        }
        return min == 0;
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