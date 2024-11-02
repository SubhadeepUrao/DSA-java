import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(Node head, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Node last = head;
        while(last.next != null) {
            if(last.data > target) {
                last = last.prev;
                break;
            }
            last = last.next;
        }
        
        while(head != null && last != null && head.data < last.data) {
            int diff = target - head.data - last.data; 
            if(diff == 0) {
                list.add(new ArrayList<>(List.of(head.data, last.data)));
                head = head.next;
                last = last.prev;
            }
            else if(diff > 0) {
                head = head.next;
            }
            else {
                last = last.prev;
            }
        }
        return list;
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
        int target = input.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = input.nextInt();
        }

        Node head = toDLL(arr);
        
        ArrayList<ArrayList<Integer>> res = findPairsWithGivenSum(head, target);

        for(int i = 0; i < res.size(); ++i) {
            output.write("[ " + res.get(i).get(0) + ", " + res.get(i).get(1) + " ]\n");
        }

        input.close();
        output.close();
    }
}