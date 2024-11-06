import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Demo {
    public static String infixToPrefix(String exp) {
        Stack<Character> st = new Stack<>();
        StringBuilder str = new StringBuilder();

        // reverse scanning and converted original infix -> postfix algo( FRONT SCANNING ) by replacing only '(' -> ')' and ')' -> '('
        for(int i = exp.length()-1; i >= 0; --i) {
            char curr = exp.charAt(i);

            if(Character.isLetterOrDigit(curr)) {
                str.append(curr);
            }
            else {
                if(st.empty()) st.push(curr);
                else {
                    char ch;
                    switch (curr) {
                        case '(':
                            while(st.peek() != ')')
                                str.append(st.pop());
                            st.pop();
                            break;
                        case ')':
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
                            while(ch != ')') {
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

        // reversing the result
        StringBuilder res = new StringBuilder();
        for(int i = str.length()-1; i >= 0; --i) {
            res.append(str.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        String str = input.next();

        String res = infixToPrefix(str);

        output.write(res);

        input.close();
        output.close();
    }
}