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
    public static int length(Node head) {
        int cnt = 0;
        while(head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }
    public Node getIntersectionNode(Node headA, Node headB) {
        int lenA = length(headA);
        int lenB = length(headB);

        int diff = lenA - lenB;

        if(diff < 0) {
            while(diff++ != 0) {
                headB = headB.next;
            }
        }
        else if(diff > 0) {
            while(diff-- != 0) {
                headA = headA.next;
            }
        }
        while(headA != null) {
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}