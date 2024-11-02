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
    public static Node reverse(Node head) {
        if(head.next == null) return head;

        Node prev = null;

        while(head != null) {
            Node temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    public static Node addTwoNumbers(Node first, Node second) {
        first = reverse(first);
        second = reverse(second);
        int carry = 0;
        Node last = null;
        Node head = first;

        while(first != null && second != null) {
            first.data = first.data + second.data + carry;
            carry = 0;
            if(first.data > 9) {
                carry = first.data / 10;
                first.data = first.data % 10;
            }
            last = first;
            first = first.next;
            second = second.next;
        }

        if(first == null && second == null && carry != 0) {
            last.next = new Node(carry);
            return reverse(head);
            // return head;
        }
    
        while(carry != 0 && first != null) {
            first.data += carry;
            carry = 0;
            if(first.data > 9) {
                carry = first.data / 10;
                first.data %= 10;
            }
            last = first;
            first = first.next;
        }
        if(second != null) {
            last.next = second;
            while(carry != 0 && second != null) {
                second.data += carry;
                carry = 0;
                if(second.data > 9) {
                    carry = second.data / 10;
                    second.data %= 10;
                }
                last = second;
                second = second.next;
            }
        }
        if(carry != 0) {
            last.next = new Node(carry);
        }
        return reverse(head);
        // return head;
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
        int m = input.nextInt();

        int[] arr = new int[n];
        int[] arr2 = new int[m];
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        for(int i = 0; i < m; i++) {
            arr2[i] = input.nextInt();
        }

        Node headA = toLL(arr);
        Node headB = toLL(arr2);
        
        headA = addTwoNumbers(headA, headB);
        
        while(headA != null) {
            output.write(headA.data + " ");
            headA = headA.next;
        }

        input.close();
        output.close();
        
    }
}