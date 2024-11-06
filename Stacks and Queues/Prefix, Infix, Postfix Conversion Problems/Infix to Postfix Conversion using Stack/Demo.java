import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Demo {
    public static String infixToPostfix(String exp) {
        Stack<Character> st = new Stack<>();
        StringBuilder str = new StringBuilder();

        for(char curr : exp.toCharArray()) {
            if(Character.isLetterOrDigit(curr)) {
                str.append(curr);
            }
            else {
                if(st.empty()) st.push(curr);
                else {
                    char ch;
                    switch (curr) {
                        case ')':
                            while(st.peek() != '(')
                                str.append(st.pop());
                            st.pop();
                            break;
                        case '(':
                            st.push(curr);
                            break;
                        case '^': // right associativity is ignored
                            // for right associativity remove below lines
                            while(!st.empty() && st.peek() == '^') {
                                str.append(st.pop());
                            }
                            // till here
                            st.push(curr);
                            break;
                        case '*':
                        case '/':
                            ch = st.peek();
                            while(ch == '^' || ch == '*' || ch == '/') {
                                str.append(st.pop());
                                if(st.empty()) break;
                                ch = st.peek();
                            }
                            st.push(curr);
                            break;
                        case '+':
                        case '-':
                            ch = st.peek();
                            while(ch != '(') {
                                str.append(st.pop());
                                if(st.empty()) break;
                                ch = st.peek();
                            }
                            st.push(curr);
                            break;
                    }
                }
            }
        }
        while(!st.empty()) {
            str.append(st.pop());
        }
        return str.toString();
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        String str = input.next();

        String res = infixToPostfix(str);

        output.write(res);

        input.close();
        output.close();
    }
}