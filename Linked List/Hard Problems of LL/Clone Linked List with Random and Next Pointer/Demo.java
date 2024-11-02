class Node
{
	int data;
	Node next;
    Node random;
	Node(int data)
	{
	    this.data = data;
	    next = random = null;
	}
}

public class Demo {
    public static Node insertInBetween(Node head) {
        Node curr = head;
        while(curr != null) {
            Node nextPtr = curr.next;
            curr.next = new Node(curr.data);
            curr.next.next = nextPtr;
            curr = nextPtr;
        }
        return head;
    }
    public static Node copyRandom(Node head) {
        Node curr = head;
        while(curr != null) {
            if(curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        return head;
    }
    public static Node segregate(Node head) {
        Node curr = head;
        Node newHead = head.next;
        Node currClone = newHead;

        while(curr != null) {
            curr.next = currClone.next;
            curr = curr.next;
            if(curr != null) {
                currClone.next = curr.next;
                currClone = currClone.next;
            }
        }
        return newHead;
    }
    public static Node deepCopy(Node head) {
        if(head == null) return head;

        head = insertInBetween(head);
        head = copyRandom(head);
        head = segregate(head);

        return head;
    }
}