import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class PriorityQueue {
    int[] heap;
    int size;

    PriorityQueue() {
        heap = new int[20];
        size = -1;
    }

    void addAll(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            insert(nums[i]);
        }
    }

    void swap(int parent, int curr) {
        int temp = heap[parent];
        heap[parent] = heap[curr];
        heap[curr] = temp;
    }

    void insert(int num) {
        ++size;
        heap[size] = num;

        int parent = (size - 1) / 2;
        int curr = size;

        while(parent >= 0 && heap[parent] < heap[curr]) {
            swap(parent, curr);
            curr = parent;
            parent = (parent - 1) / 2;
        }
    }

    int poll() {
        if(size == -1) return -1;

        int head = heap[0];
        heap[0] = heap[size];
        --size;
        
        int parent = 0, largest = 0;

        do {
            parent = largest;
            int left = parent * 2 + 1;
            int right = parent * 2 + 2;
            if(left <= size && heap[largest] < heap[left]) {
                largest = left;
            }
            if(right <= size && heap[largest] < heap[right]) {
                largest = right;
            }
            swap(parent, largest);
        } while (parent < largest);

        return head;
    }

    int peek() {
        return size > -1 ? heap[0] : -1;
    }

    int[] getHeap() {
        int[] nums = new int[size+1];
        for(int i = 0; i <= size; ++i)
            nums[i] = heap[i];
        return nums;
    }
}

public class Demo {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();
        
        PriorityQueue pq = new PriorityQueue();

        pq.addAll(nums);

        output.write("Before Extraction : " + Arrays.toString(pq.getHeap()) + "\n");

        int head = pq.poll();

        output.write("Extracted : " + head + "\n");
        output.write("After Extraction : " + Arrays.toString(pq.getHeap()));

        input.close();
        output.close();
    }
}