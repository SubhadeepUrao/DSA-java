import java.util.PriorityQueue;

class KthLargest {
    static PriorityQueue<Integer> pq;
    static int size;
    
    public KthLargest(int k, int[] nums) {
        int N = nums.length;
        pq = new PriorityQueue<>();
        size = k;

        for(int i = 0; i < k; ++i) {
            if(i == N) return;
            pq.add(nums[i]);
        }
        for(int i = k; i < N; ++i) {
            if(pq.peek() < nums[i]) {
                pq.remove();
                pq.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(pq.size() < size)
            pq.add(val);
        else if(pq.peek() < val) {
            pq.remove();
            pq.add(val);
        }
        return pq.peek();
    }
}