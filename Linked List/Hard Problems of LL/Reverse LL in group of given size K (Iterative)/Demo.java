import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Node
{
	int data;
	Node next;
	Node(int data)
	{
	    this.data = data;
	    next = null;
	}
}
public class Demo {
    public static Node reverseK(Node head, Node prev, int k) {
        while(k-- != 0) {
            Node nextPtr = head.next;
            head.next = prev;
            prev = head;
            head = nextPtr;
        }
        return prev;
    }
    public static Node reverseKGroup(Node head, int k) {
        if(head == null || head.next == null) return head;

        Node curr = head;
        Node last = head;
        Node newHead = null;

        while(curr != null) {
            int cnt = k;
            // get the Kth node
            while(curr != null && --cnt != 0) {
                curr = curr.next;
            }

            if(cnt == 0) {
                if(newHead == null) {
                    newHead = reverseK(head, curr.next, k);
                }
                else {
                    Node start = last.next;
                    last.next = reverseK(start, curr.next, k);
                    last = start;
                }
                curr = last.next;
            }
        }
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
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int k = input.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = input.nextInt();
        }

        Node head = toLL(arr);
        
        head = reverseKGroup(head, k);

        while(head != null) {
            output.write(head.data + " ");
            head = head.next;
        }

        input.close();
        output.close();
    }
}