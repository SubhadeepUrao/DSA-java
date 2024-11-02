import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Demo {
    public static Stack<Integer> sortInsert(Stack<Integer> stack, int n) {
        if(stack.isEmpty() || stack.peek() <= n) {
            stack.push(n);
            return stack;
        }

        int top = stack.pop();
        sortInsert(stack, n);
        stack.push(top);

        return stack;
    }
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        if(stack.isEmpty()) return stack;

        int top = stack.pop();
        sortStack(stack);

        return sortInsert(stack, top);
    }
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        Stack<Integer> stack = new Stack<>();
        while(input.hasNextInt()) {
            stack.push(input.nextInt());
        }

        stack = sortStack(stack);

        while(!stack.isEmpty()){
            output.write(stack.pop() + " ");
        }

        input.close();
        output.close();
        
    }
}
