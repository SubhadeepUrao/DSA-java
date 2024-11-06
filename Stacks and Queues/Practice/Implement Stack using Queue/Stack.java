import java.util.ArrayDeque;

public class Stack {
    private ArrayDeque<Integer> q;

    public Stack() {
        q = new ArrayDeque<>();
    }
    
    public void push(int x) {
        int size = q.size();
        q.add(x);
        while(size > 0) {
            q.add(q.poll());
            --size;
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.peek() == null ? true : false;
    }
}