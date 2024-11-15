import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    static int parent(int i) { return (i -  1) >> 1; }
    static int left(int i) { return (i << 1) + 1; }
    static int right(int i) { return (i << 1) + 2; }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void maxHeapify(int[] nums, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;

        if(l < nums.length && nums[l] > nums[i]) largest = l;
        if(r < nums.length && nums[r] > nums[largest]) largest = r;

        if(largest != i) {
            swap(nums, i, largest);
            maxHeapify(nums, largest);
        }
    }

    public static void minHeapToMaxHeap(int[] nums) {
        int N = nums.length;

        // start from the first non-leaf node from bootom
        for(int i = (N >> 1) - 1; i >= 0; --i)
            maxHeapify(nums, i);
    }
    
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();
        
        minHeapToMaxHeap(nums);
        
        output.write(Arrays.toString(nums));
        
        input.close();
        output.close();
    }
}