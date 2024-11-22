import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Demo {
    static class Node {
        int data;
        Node prev;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    static Node head = new Node(-1), tail = new Node(-1);
    static HashMap<Integer, Node> mpp = new HashMap<>();

    static {
        head.next = tail;
        tail.prev = head;
    }
    
    static void insert(int data) {
        Node curr = new Node(data);
        mpp.put(data, curr);
        curr.next = tail;
        curr.prev = tail.prev;
        tail.prev.next = curr;
        tail.prev = curr;
    }
    static void remove(int data) {
        Node curr = mpp.get(data);
        mpp.remove(data);
        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;
        curr.next = null;
        curr.prev = null;
    }
    static int pageFaults(int N, int C, int pages[]){
        int faults = 0;
        for(int page : pages) {
            if(mpp.size() < C) {
                if(mpp.containsKey(page)) remove(page);
                else {
                    faults++;
                    System.out.println(faults + " : " + page);
                }
                insert(page);
            }
            else {
                if(mpp.containsKey(page)) remove(page);
                else {
                    remove(head.next.data);
                    faults++;
                    System.out.println(faults + " : " + page);
                }
                insert(page);
            }
        }
        return faults;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i)
            nums[i] = input.nextInt();
        
        int capacity = input.nextInt();
        
        int res = pageFaults(n, capacity, nums);
        
        output.write(Integer.toString(res));
        
        input.close();
        output.close();
    }
}