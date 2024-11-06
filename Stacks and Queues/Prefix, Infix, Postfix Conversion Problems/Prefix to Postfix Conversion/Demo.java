import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Demo {
    public static String prefixToPostfix(String preExp) {
        Stack<String> st = new Stack<>();
        
        for(int i = preExp.length()-1; i >= 0; --i) {
            char curr = preExp.charAt(i);
            
            if(Character.isLetter(curr))
                st.push(Character.toString(curr));
            else 
                st.push(st.pop() + st.pop() + Character.toString(curr));
        }
        return st.pop();
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        String str = input.next();

        String res = prefixToPostfix(str);

        output.write(res);

        input.close();
        output.close();
    }
}