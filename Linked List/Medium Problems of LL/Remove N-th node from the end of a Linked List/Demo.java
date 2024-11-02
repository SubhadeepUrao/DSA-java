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
    public static Node removeKthNode(Node head, int K) {
        Node fast = head;

        for(int i = 0; i < K; ++i) 
            fast = fast.next;
        
        if(fast == null) return head.next;

        Node slow = head;

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node delNode = slow.next;
        slow.next = slow.next.next;
        delNode.next = null;

        return head;
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
        int k = input.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        Node head = toLL(arr);
        // traverse(head);
        
        head = removeKthNode(head, k);
        
        while(head != null) {
            output.write(head.data + " ");
            head = head.next;
        }

        input.close();
        output.close();
        
    }
}