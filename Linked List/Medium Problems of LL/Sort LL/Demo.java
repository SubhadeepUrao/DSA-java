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
    public static Node findMidNode(Node head) {
        Node tortoise = head;
        Node hare = head;

        while(hare.next != null && hare.next.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }

        Node midNode = tortoise.next;
        tortoise.next = null;
        return midNode;
    }
    public static Node merge(Node first, Node second) {
        Node head = null;
        Node last = null;

        while(first != null && second != null) {
            if(first.data <= second.data) {
                if(head != null) last.next = first;
                else head = first;

                last = first;
                first = first.next;
            }
            else {
                if(head != null) last.next = second;
                else head = second;

                last = second;
                second = second.next;
            }
        }
        if(first != null) last.next = first;
        else last.next = second;

        return head;
    }
    public static Node sortLL(Node head) {
        if(head == null || head.next == null) return head;

        Node mid = findMidNode(head);
        Node left = sortLL(head);
        Node right = sortLL(mid);

        return merge(left, right);
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
        
        head = sortLL(head);
        
        while(head != null) {
            output.write(head.data + " ");
            head = head.next;
        }

        input.close();
        output.close();
        
    }
}