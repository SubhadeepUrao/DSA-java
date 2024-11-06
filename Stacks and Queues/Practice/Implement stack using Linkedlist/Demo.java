class MyStack {
    class StackNode {
        int data;
        StackNode next;
        StackNode(int a) {
            data = a;
            next = null;
        }
    }
    StackNode top;
    int elementCount;

    // Function to push an integer into the stack.
    void push(int a) {
        StackNode temp = new StackNode(a);
        temp.next = top;
        top = temp;
        elementCount++;
    }

    // Function to remove an item from top of the stack.
    int pop() {
        if(top == null) return -1;
        StackNode temp = top;
        top = top.next;
        temp.next = null;
        elementCount--;
        return temp.data;
    }

    int size() {
        return elementCount;
    }

    boolean isEmpty() {
        return top == null ? true : false;
    }
}