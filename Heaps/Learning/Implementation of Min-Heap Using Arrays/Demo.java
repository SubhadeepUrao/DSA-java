import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class MinHeap {
    int[] heap;
    int heap_size;
    int capacity;

    MinHeap(int cap) {
        heap = new int[cap];
        heap_size = 0;
        capacity = cap;
    }

    int parent(int i) { return (i - 1) / 2; }
    int leftChild(int i) { return i * 2 + 1; }
    int rightChild(int i) { return i * 2 + 2; }

    int extractMin() {
        if(heap_size == 0) return -1;

        int root = heap[0];
        heap[0] = heap[--heap_size];

        minHeapify(0);

        return root;
    }

    void insert(int key) {
        if(capacity == heap_size) return;

        upwardFix(heap_size, key);
        ++heap_size;
    }

    void delete(int i) {
        if(heap_size <= i) return;

        upwardFix(i, heap[--heap_size]);
        minHeapify(i);
    }

    void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    void upwardFix(int i, int key) { 
        heap[i] = key;

        while(i > 0 && heap[parent(i)] > heap[i]) {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    void minHeapify(int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int smallest = i;

        if(l < heap_size && heap[l] < heap[i]) smallest = l;
        if(r < heap_size && heap[r] < heap[smallest]) smallest = r;

        if(smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    int[] getMinHeap() {
        int[] nums = new int[heap_size];

        for(int i = 0; i < heap_size; ++i)
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
        System.out.println(Arrays.toString(nums));
        MinHeap minheap = new MinHeap(30);

        for(int key : nums)
            minheap.insert(key);

        output.write("Initially : " + Arrays.toString(minheap.getMinHeap()) + "\n");

        minheap.delete(3);
        output.write("Deleting at 3 : " + Arrays.toString(minheap.getMinHeap()) + "\n");

        int root = minheap.extractMin();

        output.write("Extracted : " + root + "\n");
        output.write("After Extraction : " + Arrays.toString(minheap.getMinHeap()));

        input.close();
        output.close();
    }
}