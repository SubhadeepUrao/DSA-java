public class Stack {

    private int[] stack;
    private int top;

    public Stack() {
        stack = new int[100];
        top = -1;
    }
    public void push(int data) {
        if(top != 100) stack[++top] = data;
    }
    public int pop() {
        if(top == -1) return -1;
        return stack[top--];
    }
    public boolean isEmpty() {
        if(top == -1) return true;
        return false;
    }
    public int peek() {
        if(top != -1) return stack[top];
        return -1;
    }
    public int size() {
        return top + 1;
    }
}