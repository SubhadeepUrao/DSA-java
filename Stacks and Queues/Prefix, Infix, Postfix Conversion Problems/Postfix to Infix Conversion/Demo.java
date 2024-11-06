import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Demo {
    public static String postfixToInfix(String postExp) {
        Stack<String> st = new Stack<>();

        for(char curr : postExp.toCharArray()) {
            if(Character.isLetter(curr))
                st.push(Character.toString(curr));
            else {
                String second = st.pop();
                st.push(st.pop() + Character.toString(curr) + second);
            }
        }
        return st.pop();
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        String str = input.next();

        String res = postfixToInfix(str);

        output.write(res);

        input.close();
        output.close();
    }
}