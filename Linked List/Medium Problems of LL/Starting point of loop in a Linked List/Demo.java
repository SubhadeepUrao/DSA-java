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
    public String toString() {
        return String.valueOf(data);
    }
}
public class Demo {
    public static Node firstLoopNode(Node head) {
        Node hare = head;
        Node tortoise = head;

        while(hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if(hare == tortoise) {
                hare = head;

                while(hare != tortoise) {
                    hare = hare.next;
                    tortoise = tortoise.next;
                }
                return hare;
            }
        }
        return null;
    }
    public static Node toLL(int[] arr, int cyclePos) {
        int n = arr.length;
        Node head = new Node(arr[0]);
        Node ptr = head;
        Node cycNode = head;

        for(int i = 1; i < n; ++i) {
            ptr.next = new Node(arr[i]);
            ptr = ptr.next;

            if(cyclePos == i) cycNode = ptr;
        }
        if(cyclePos > -1) {
            ptr.next = cycNode;
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

        int cyclePos = input.nextInt();

        Node head = toLL(arr, cyclePos);
        // traverse(head);
        
        Node loopHead = firstLoopNode(head);
        
        output.write(String.valueOf(loopHead));

        input.close();
        output.close();
        
    }
}