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
    public static boolean detectCycle(Node head) {
        Node tortoise = head;
        Node hare = head;
        while(hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if(hare == tortoise) return true;
        }
        return false;
    }
    public static Node toLL(int[] arr, int cyclePos) {
        int n = arr.length;
        Node head = new Node(arr[0]);
        Node ptr = head;
        Node cycNode = head;

        for(int i = 1; i < n; ++i) {
            ptr.next = new Node(arr[i]);
            ptr = ptr.next;

            if(cyclePos == i+1) cycNode = ptr;
        }
        if(cyclePos != 0) {
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
        
        boolean cycle = detectCycle(head);

        output.write(Boolean.toString(cycle));

        input.close();
        output.close();
        
    }
}