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
    // version 1.0
    // public static Node deleteMiddle(Node head) {
    //     if(head == null || head.next == null) return null;
    //     Node tortoise = head;
    //     Node hare = head.next;

    //     while(hare.next != null && hare.next.next != null) {
    //         tortoise = tortoise.next;
    //         hare = hare.next.next;
    //     }
    //     tortoise.next = tortoise.next.next;
    //     return head;
    // }

    // version 2.0
    // public ListNode deleteMiddle(ListNode head) {
    //     if(head ==  null || head.next == null) return null;

    //     ListNode tortoise = head;
    //     ListNode hare = head.next.next;

    //     while(hare != null && hare.next != null) {
    //         tortoise = tortoise.next;
    //         hare = hare.next.next;
    //     }
    //     ListNode delNode = tortoise.next;
    //     tortoise.next = tortoise.next.next;
    //     delNode.next = null;

    //     return head;
    // }
    
    // version 3.0
    public static Node deleteMiddle(Node head) {
        Node hare = head;
        Node tortoise = head;

        while(hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare =hare.next.next;
        }

        tortoise.data = tortoise.next.data;
        tortoise.next = tortoise.next.next;
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

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        Node head = toLL(arr);
        // traverse(head);
        
        head = deleteMiddle(head);
        
        while(head != null) {
            output.write(head.data + " ");
            head = head.next;
        }
        input.close();
        output.close();
        
    }
}