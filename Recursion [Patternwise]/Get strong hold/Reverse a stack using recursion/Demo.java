import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Demo {
    public static void insertAtBottom(Stack<Integer> stack, int n) {
        if(stack.isEmpty()) {
            stack.push(n);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, n);
        stack.push(top);
    }
    public static void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty()) return;

        int top = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, top);
    }
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        Stack<Integer> stack = new Stack<>();
        while(input.hasNextInt()) {
            stack.push(input.nextInt());
        }

        reverseStack(stack);

        while(!stack.isEmpty()){
            output.write(stack.pop() + " ");
        }

        input.close();
        output.close();
        
    }
}
