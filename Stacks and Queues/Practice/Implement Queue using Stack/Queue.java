import java.util.Stack;

public class Queue {

    private Stack<Integer> firstStack;
    private Stack<Integer> secondStack;

    public Queue() {
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }
    
    public void push(int x) {
        while(!firstStack.empty()) {
            secondStack.push(firstStack.pop());
        }
        firstStack.push(x);
        while(!secondStack.empty()) {
            firstStack.push(secondStack.pop());
        }
    }
    
    public int pop() {
        // if(firstStack.empty()) return -1; // Stack
        // if(firstStack.isEmpty()) return -1; // Vector
        return firstStack.pop();
    }
    
    public int peek() {
        return firstStack.peek();
    }
    
    public boolean empty() {
        return firstStack.empty();
    }
}