import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}
public class Demo {
    public static Node removeDuplicates(Node head) {
        if(head.next == null) return head;

        Node curr = head;

        while(curr != null) {
            if(curr.prev != null && curr.data == curr.prev.data) {
                Node temp = curr;
                curr.prev.next = curr.next;
                if(curr.next != null)
                    curr.next.prev = curr.prev;
                curr.prev = null;
                curr = curr.next;
                temp.next = null;
            }
            else
                curr = curr.next;
        }
        return head;
    }
    public static Node toDLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node ptr = head;
        int n = arr.length;
        for(int i = 1; i < n; ++i) {
            ptr.next = new Node(arr[i]);
            ptr.next.prev = ptr;
            ptr = ptr.next;
        }

        return head;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = input.nextInt();
        }

        Node head = toDLL(arr);
        
        head = removeDuplicates(head);

        while(head != null) {
            output.write(head.data + " ");
            head = head.next;
        }

        input.close();
        output.close();
    }
}