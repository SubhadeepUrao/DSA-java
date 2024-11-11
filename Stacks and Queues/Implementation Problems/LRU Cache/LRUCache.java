import java.util.HashMap;

public class LRUCache {
    class Node {
        int key;
        int data;
        Node prev, next;
        public Node(int key, int data) {
            this.key = key;
            this.data = data;
            prev = next = null;
        }
    }

    int capacity;
    int elementCnt;
    Node tail;
    Node head;
    HashMap<Integer, Node> mpp;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        mpp = new HashMap<>();
    }
    
    public int get(int key) {
        if(mpp.containsKey(key)) {
            Node curr = mpp.get(key);
            if(tail != curr)
                moveNodeToEnd(curr);
            return curr.data;
        }
        return -1;
    }

    public void moveNodeToEnd(Node curr) {
        if(head == curr) head = head.next;

        if(curr.next != null) curr.next.prev = curr.prev;
        if(curr.prev != null) curr.prev.next = curr.next;
        
        curr.prev = tail;
        tail.next = curr;
        tail = curr;
        curr.next = null;
    }

    public void insertNodeAtEnd(Node curr) {
        if(head == null) {
            head = tail = curr;
        }
        else {
            tail.next = curr;
            curr.prev = tail;
            tail = curr;
        }
    }

    public Node removeHead() {
        Node evictNode = head;
        head = head.next;
        if(head != null) {
            head.prev.next = null;
            head.prev = null;
        }
        return evictNode;
    }
    
    public void put(int key, int value) {

        if(mpp.containsKey(key)) {
            Node curr = mpp.get(key);
            // if(curr.data != value) {
                curr.data = value;
            // }
            if(tail != curr)
                moveNodeToEnd(curr);
            return;
        }

        Node curr = new Node(key, value);

        if(elementCnt < capacity) {
            insertNodeAtEnd(curr);
            mpp.put(key, curr);
            ++elementCnt;
        }
        else {
            Node evictNode = removeHead();
            mpp.remove(evictNode.key);
            insertNodeAtEnd(curr);
            mpp.put(key, curr);
        }
    }
}