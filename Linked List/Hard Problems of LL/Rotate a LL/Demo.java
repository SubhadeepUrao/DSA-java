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
    public static int size(Node head) {
        int cnt = 0;
        while(head != null) {
            ++cnt;
            head = head.next;
        }
        return cnt;
    }
    public static Node rotateRight(Node head, int k) {
        if(k == 0 || head == null || head.next == null) return head;

        int n = size(head);
        k %= n;
        
        Node fast = head;
        while(k-- != 0) {
            fast = fast.next;
        }
        Node slow = head;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;

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
        
        head = rotateRight(head, k);

        while(head != null) {
            output.write(head.data + " ");
            head = head.next;
        }

        input.close();
        output.close();
    }
}