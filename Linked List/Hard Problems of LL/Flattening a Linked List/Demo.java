class Node {
    int data;
    Node next, bottom;
    Node(int data) {
        this.data = data;
        next = bottom = null;
    }
}
public class Demo {
    public static Node findMidNode(Node head) {
        Node tortoise = head;
        Node hare = head;

        while(hare.bottom != null && hare.bottom.bottom != null) {
            tortoise = tortoise.bottom;
            hare = hare.bottom.bottom;
        }

        Node midNode = tortoise.bottom;
        tortoise.bottom = null;
        return midNode;
    }
    public static Node merge(Node first, Node second) {
        Node head = null;
        Node last = null;

        while(first != null && second != null) {
            if(first.data <= second.data) {
                if(head != null) last.bottom = first;
                else head = first;

                last = first;
                first = first.bottom;
            }
            else {
                if(head != null) last.bottom = second;
                else head = second;

                last = second;
                second = second.bottom;
            }
        }
        if(first != null) last.bottom = first;
        else last.bottom = second;

        return head;
    }
    public static Node sortLL(Node head) {
        if(head == null || head.bottom == null) return head;

        Node mid = findMidNode(head);
        Node left = sortLL(head);
        Node right = sortLL(mid);

        return merge(left, right);
    }
    // Function to flatten a linked list
    Node flatten(Node root) {
        Node curr = root;
        Node currBottom;
        while(curr != null) {
            currBottom = curr;
            while(currBottom.bottom != null) {
                currBottom = currBottom.bottom;
            }
            currBottom.bottom = curr.next;
            curr.next = null;
            curr = currBottom.bottom;
        }
        return sortLL(root);
        
    }
}