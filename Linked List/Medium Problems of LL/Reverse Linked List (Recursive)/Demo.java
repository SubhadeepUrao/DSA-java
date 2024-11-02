import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Node {
    public int data;
    public Node next;

    Node()
    {
        this.data = 0;
        this.next = null;
    }
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}
public class Demo {
    public static Node reverseLinkedList(Node head) {
        if(head == null || head.next == null) return head;

        Node newHead = reverseLinkedList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
    public static Node toLL(int[] arr) {
        int n = arr.length;
        Node head = new Node(arr[0]);
        Node ptr = head;
        for(int i = 1; i < n; ++i) {
            ptr.next = new Node(arr[i]);
            ptr = ptr.next;
        }
        return head;
    }
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        Node head = toLL(arr);
        // traverse(head);
        
        head = reverseLinkedList(head);

        while(head != null) {
            output.write(head.data + " ");
            head = head.next;
        }

        input.close();
        output.close();
        
    }
}