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
    public static Node deleteAllOccurrence(Node head, int key) {
        Node curr = head;
        while(curr != null) {
            if(curr.data != key) curr = curr.next;
            else {
                if(curr != head) {
                    Node temp = curr.next;
                    curr.prev.next = temp;

                    if(temp != null)
                        temp.prev = curr.prev;
                    
                    curr.next = null;
                    curr.prev = null;
                    curr = temp;
                }
                else {
                    head = head.next;
                    if(head != null) {
                        head.prev.next = null;
                        head.prev = null;
                    }
                    curr = head;
                }
            }
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

        int key = input.nextInt();

        Node head = toDLL(arr);
        
        head = deleteAllOccurrence(head, key);

        while(head != null) {
            output.write(head.data + " ");
            head = head.next;
        }

        input.close();
        output.close();
    }
}