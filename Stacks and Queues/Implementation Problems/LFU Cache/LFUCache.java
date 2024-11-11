import java.io.FileWriter;
import java.io.IOException;

class LFUCache {
    class Node {
        int key;
        int data;
        int freq;
        Node prev, next;
        public Node(int key, int data) {
            this.key = key;
            this.data = data;
            prev = next = null;
        }
    }

    FileWriter output;
    int capacity;
    int elementCnt;
    Node head;
    Node[] mpp;
    Node[] freqTail;

    public LFUCache(int capacity, FileWriter output) {
        this.capacity = capacity;
        mpp = new Node[100001];
        freqTail = new Node[200001];
        this.output = output;
    }

    public void nodeWithHeadAndFreqTail(Node curr) {
        if(head.next == null || freqTail[curr.freq+1] == null) {
            freqTail[curr.freq+1] = curr;
            freqTail[curr.freq] = null;
        }
        else {
            head = head.next;
            head.prev = null;
            freqTail[curr.freq] = null;
            curr.prev = freqTail[curr.freq+1];
            curr.next = freqTail[curr.freq+1].next;
            curr.prev.next = curr;
            if(curr.next != null) curr.next.prev = curr;
            freqTail[curr.freq+1] = curr;
        }
    }

    public void nodeWithFreqTail(Node curr) {
        if(curr.freq != curr.prev.freq)
            freqTail[curr.freq] = null;
        else
            freqTail[curr.freq] = curr.prev;
        
        if(freqTail[curr.freq+1] == null) {
            freqTail[curr.freq+1] = curr;
        }
        else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            curr.next = freqTail[curr.freq+1].next;
            curr.prev = freqTail[curr.freq+1];
            curr.prev.next = curr;
            if(curr.next != null) curr.next.prev = curr;
            freqTail[curr.freq+1] = curr;
        }
    }

    public void regularNodeWithHead(Node curr) {
        head = head.next;
        head.prev.next = null;
        head.prev = null;
        if(freqTail[curr.freq+1] == null) {
            curr.prev = freqTail[curr.freq];
            curr.next = freqTail[curr.freq].next;
            curr.prev.next = curr;
            if(curr.next != null) curr.next.prev = curr;
            freqTail[curr.freq+1] = curr;
        }
        else {
            curr.prev = freqTail[curr.freq+1];
            curr.next = freqTail[curr.freq+1].next;
            curr.prev.next = curr;
            if(curr.next != null) curr.next.prev = curr;
            freqTail[curr.freq+1] = curr;
        }
    }

    public void regularNode(Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        if(freqTail[curr.freq+1] == null) {
            curr.prev = freqTail[curr.freq];
            curr.next = freqTail[curr.freq].next;
            curr.prev.next = curr;
            if(curr.next != null) curr.next.prev = curr;
            freqTail[curr.freq+1] = curr;
        }
        else {
            curr.prev = freqTail[curr.freq+1];
            curr.next = freqTail[curr.freq+1].next;
            curr.prev.next = curr;
            if(curr.next != null) curr.next.prev = curr;
            freqTail[curr.freq+1] = curr;
        }
    }

    public void moveNodeNext(Node curr) {
        if(curr == head && curr == freqTail[curr.freq])
            nodeWithHeadAndFreqTail(curr);
        else if(curr != head && curr == freqTail[curr.freq])
            nodeWithFreqTail(curr);
        else if(curr == head && curr != freqTail[curr.freq])
            regularNodeWithHead(curr);
        else
            regularNode(curr);
    }

    public int get(int key) throws IOException {
        if(mpp[key] != null) {
            Node curr = mpp[key];

            moveNodeNext(curr);
            ++curr.freq;
            output.write(curr.key + ":" + curr.data + " >> ");
            traverse();
            return curr.data;
        }
        output.write("-1\n");
        return -1;
    }
    
    public void deleteNode(Node curr) {
        if(head == curr) {
            if(curr == freqTail[curr.freq]) {
                freqTail[curr.freq] = null;
                head = head.next;
                if(head != null) {
                    head.prev.next = null;
                    head.prev = null;
                }
            }
            else {
                head = head.next;
                head.prev.next = null;
                head.prev = null;
            }
        }
        else {
            if(curr == freqTail[curr.freq]) {
                if(curr.prev.freq != curr.freq)
                    freqTail[curr.freq] = null;
                else
                    freqTail[curr.freq] = curr.prev;
                
                curr.prev.next = curr.next;
                if(curr.next != null) curr.next.prev = curr.prev;
            }
            else {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
            }
        }
        curr.prev = curr.next = null;
    }

    public void insertCapacityNotFull(Node curr) {
        if(head == null && freqTail[0] == null) {
            head = freqTail[0] = curr;
        }
        else if(freqTail[0] == null) {
            freqTail[0] = curr;
            curr.next = head;
            head.prev = curr;
            head = curr;
        }
        else {
            curr.prev = freqTail[0];
            curr.next = freqTail[0].next;
            curr.prev.next = curr;
            if(curr.next != null) curr.next.prev = curr;
            freqTail[0] = curr;
        }
    }

    public Node insertCapacityFull() {
        if(freqTail[0] == null) {
            if(head == freqTail[head.freq]) {
                freqTail[head.freq] = null;
            }
            freqTail[0] = head;
        }
        else {
            if(head != freqTail[0]) {
                Node curr = head;
                head = head.next;
                head.prev= null;
                curr.prev = freqTail[0];
                curr.next = freqTail[0].next;
                curr.prev.next = curr;
                if(curr.next != null) curr.next.prev = curr;
                freqTail[0] = curr;
                return curr;
            }
        }
        return head;
    }

    public void put(int key, int value) throws IOException {
        output.write("{" + key + ":" + value + "} >> ");
        Node curr;
        if(mpp[key] != null) {
            curr = mpp[key];
            curr.data = value;
            moveNodeNext(curr);
            ++curr.freq;
            traverse();
            return;
        }
        // if(mpp[key] != null) {
        //     curr = mpp[key];
        //     deleteNode(curr);
        //     curr = new Node(key, value);
        //     insertCapacityNotFull(curr);
        //     mpp[key] = curr;
        //     traverse();
        //     return;
        // }

        if(elementCnt < capacity) {
            curr = new Node(key, value);
            insertCapacityNotFull(curr);
            mpp[key] = curr;
            ++elementCnt;
        }
        else {
            curr = insertCapacityFull();
            mpp[curr.key] = null;
            curr.data = value;
            curr.key = key;
            curr.freq = 0;
            mpp[key] = curr;
        }
        traverse();
    }

    public void traverse() throws IOException {
        Node curr = head;
        while(curr != null) {
            if(curr == freqTail[curr.freq])
                output.write("[" + curr.key + ":" + curr.data + "] " + "(" + curr.freq + ") ");
            else
                output.write("[" + curr.key + ":" + curr.data + "] = ");
            curr = curr.next;
        }
        output.write("\n");
    }

    public static void main(String[] args) throws IOException {
        FileWriter output = new FileWriter("output.txt");

        LFUCache lfu = new LFUCache(10, output);
        
        lfu.put(10, 13);
        lfu.put(3, 17);
        lfu.put(6, 11);
        lfu.put(10, 5);
        lfu.put(9, 10);
        lfu.get(13);
        lfu.put(2, 19);
        lfu.get(2);
        lfu.get(3);
        lfu.put(5, 25);
        lfu.get(8);
        lfu.put(9, 22);
        lfu.put(5, 5);
        lfu.put(1, 30);
        lfu.get(11);
        lfu.put(9, 12);
        lfu.get(7);
        lfu.get(5);
        lfu.get(8);
        lfu.get(9);
        lfu.put(4, 30);
        lfu.put(9, 3);
        lfu.get(9);
        lfu.get(10);
        lfu.get(10);
        lfu.put(6, 14);
        lfu.put(3, 1);
        lfu.get(3);
        lfu.put(10, 11);
        lfu.get(8);
        lfu.put(2, 14);
        lfu.get(1);
        lfu.get(5);
        lfu.get(4);
        lfu.put(11, 4);
        lfu.put(12, 24);
        lfu.put(5, 18);
        lfu.get(13);
        lfu.put(7, 23);
        lfu.get(8);
        lfu.get(12);
        lfu.put(3, 27);
        lfu.put(2, 12);
        lfu.get(5);
        lfu.put(2, 9);
        lfu.put(13, 4);
        lfu.put(8, 18);
        lfu.put(1, 7);
        lfu.get(6);

        output.close();
    }
}
