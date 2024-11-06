import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Demo {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i = 0; i < len; ++i) {
            char ch = s.charAt(i);
            switch(ch) {
                case ')': 
                    if(stack.empty()) return false;
                    if(stack.pop() != '(') return false;
                    break;
                case '}':
                    if(stack.empty()) return false;
                    if(stack.pop() != '{') return false;
                    break;
                case ']':
                    if(stack.empty()) return false;
                    if(stack.pop() != '[') return false;
                    break;
                default:
                    stack.push(ch);
            }
        }
        if(stack.empty()) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        String str = input.next();

        boolean res = isValid(str);

        output.write(res + "");

        input.close();
        output.close();
    }
}