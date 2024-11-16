class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {

    static int left(int i) { return i * 2 + 1; }
    static int right(int i) { return i * 2 + 2; }

    public static void minHeapify(ListNode[] lists, int i, int heapsize) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if(lists[i] == null) return;

        if(l < heapsize && lists[l] != null && lists[l].val < lists[i].val) smallest = l;
        if(r < heapsize && lists[r] != null && lists[r].val < lists[smallest].val) smallest = r;

        if(smallest != i) {
            swap(lists, i, smallest);
            minHeapify(lists, smallest, heapsize);
        }
    }

    public static void swap(ListNode[] lists, int i, int j) {
        ListNode temp = lists[i];
        lists[i] = lists[j];
        lists[j] = temp;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int N = lists.length;
        int heapsize = N;

        if(N == 0) return null;

        for(int i = (N / 2) - 1; i >= 0; --i) {
            while(heapsize > 0 && lists[i] == null)
                swap(lists, i, --heapsize);
            minHeapify(lists, i, heapsize);
        }

        ListNode head = null, tail = null;

        while(lists[0] != null) {
            if(head != null) {
                tail.next = lists[0];
                tail = tail.next;
            }
            else head = tail = lists[0];

            lists[0] = lists[0].next;

            while(heapsize > 0 && lists[0] == null)
                swap(lists, 0, --heapsize);

            minHeapify(lists, 0, heapsize);
        }
        return head;
    }
}