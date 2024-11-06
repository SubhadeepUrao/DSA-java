public class Queue {
    class QueueNode {
        int data;
        QueueNode next;

        QueueNode(int a) {
            data = a;
            next = null;
        }
    }

    QueueNode front, rear;
    int elementCnt;

    // Function to push an element into the queue.
    void push(int a) {
        elementCnt++;
        if (front == null) {
            front = rear = new QueueNode(a);
            return;
        }
        rear.next = new QueueNode(a);
        rear = rear.next;
    }

    // Function to pop front element from the queue.
    int pop() {
        if (front == null)
            return -1;
        QueueNode temp = front;
        front = front.next;
        temp.next = null;
        elementCnt--;

        if (front == null)
            rear = null;

        return temp.data;
    }

    int size() {
        return elementCnt;
    }

    int peek() {
        if (front == null)
            return -1;
        return front.data;
    }

    boolean isEmpty() {
        return front == null ? true : false;
    }
}