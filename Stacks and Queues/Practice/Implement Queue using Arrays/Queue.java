public class Queue {

    private int[] queue;
    private int front;
    private int rear;
    private int maxSize;

    public Queue(int maxSize) {
        queue = new int[maxSize];
        front = 0;
        rear = 0;
        this.maxSize = maxSize;
    }

    public void push(int x) {
        int temp = (rear + 1) % maxSize;
        if (front != temp) {
            rear = temp;
            queue[rear] = x;
        }
    }

    public int pop() {
        if (front != rear) {
            front = (front + 1) % maxSize;
            return queue[front];
        }
        return -1;
    }

    public int peek() {
        if (front != rear) return queue[(front + 1) % maxSize];
        return -1;
    }

    public boolean isEmpty() {
        if(front != rear) return true;
        return false;
    }

    public int size() {
        if(front == rear) return 0;
        if(front < rear) return rear - front;
        return maxSize - front + rear + 1;
    }
}