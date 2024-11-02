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
    public static Node reverseLL(Node head) {
        if(head == null || head.next == null) return head;

        Node newHead = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public static Node addOne(Node head) {
        head = reverseLL(head);

        Node curr = head;
        int carry = 1;

        while(curr.next != null) {
            curr.data += carry;
            carry = 0;
            if(curr.data > 9) {
                carry = curr.data / 10;
                curr.data %= 10;
            }
            else break;
            curr = curr.next;
        }

        if(carry != 0) {
            curr.data += carry;
            if(curr.data > 9) {
                curr.next = new Node(curr.data / 10);
                curr.data %= 10;
            }
        }
        return reverseLL(head);
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
        
        head = addOne(head);
        
        while(head != null) {
            output.write(head.data + " ");
            head = head.next;
        }

        input.close();
        output.close();
        
    }
}