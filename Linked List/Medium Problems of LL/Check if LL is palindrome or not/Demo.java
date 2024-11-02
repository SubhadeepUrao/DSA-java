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
    public static boolean isPalindrome(Node head) {
        if(head == null || head.next == null) return true;

        Node hare = head;
        Node tortoise = head;

        while(hare.next != null && hare.next.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }

        Node first = head;
        Node second = reverseLL(tortoise.next);

        while(second != null) {
            if(first.data != second.data) return false;
            first = first.next;
            second = second.next;
        }
        return true;
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
        
        boolean res = isPalindrome(head);
        
        output.write(Boolean.toString(res));

        input.close();
        output.close();
        
    }
}