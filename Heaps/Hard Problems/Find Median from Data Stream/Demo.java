import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        right = new PriorityQueue<>(); // minheap
        left = new PriorityQueue<>(Collections.reverseOrder()); // maxheap
    }
    
    public void addNum(int num) {
        right.add(num);
        while(left.peek() != null && left.peek() > num) {
            right.add(left.remove());
            left.add(right.remove());
        }
        if(left.size() < right.size()) {
            left.add(right.remove());
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }
        return left.peek();
    }
}