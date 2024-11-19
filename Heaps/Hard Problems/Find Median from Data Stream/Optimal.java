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
        if(left.size() == right.size()) {
            if (left.size() != 0) {
                if (num <= right.peek()) {
                    left.add(num);
                } else {
                    left.add(right.remove());
                    right.add(num);
                }
            } else {
                left.add(num);
            }
        } else {
            // put element into the right queue
            if (left.peek() >= num) {
                right.add(left.remove());
                left.add(num);
            } else {
                right.add(num);
            }

        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }
        return left.peek();
    }
}