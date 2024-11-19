import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Demo {
    
    public static int[] topKFrequent(int[] nums, int k) {
        // Map to count the frequency of each element
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        // Priority Queue (min-heap) to store the top k elements based on frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int key : mpp.keySet()) {
            int freq = mpp.get(key);
            pq.add(new int[]{key, freq});

            if (pq.size() > k) {
                pq.remove(); // Remove the element with the lowest frequency
            }
        }

        // Extract the top k frequent elements from the heap
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            res[i] = pq.remove()[0];
        }

        return res;
    }

    // public static int[] topKFrequent(int[] nums, int k) {
    //     // Map to count the frequency of each element
    //     HashMap<Integer, Integer> mpp = new HashMap<>();
    //     for (int num : nums) {
    //         mpp.put(num, mpp.getOrDefault(num, 0) + 1);
    //     }

    //     // Priority Queue (min-heap) to store the top k elements based on frequency
    //     PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

    //     for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
    //         int num = entry.getKey();
    //         int freq = entry.getValue();
    //         pq.add(new int[]{num, freq});

    //         if (pq.size() > k) {
    //             pq.remove(); // Remove the element with the lowest frequency
    //         }
    //     }

    //     // Extract the top k frequent elements from the heap
    //     int[] res = new int[k];
    //     for (int i = k - 1; i >= 0; --i) {
    //         res[i] = pq.poll()[0];
    //     }

    //     return res;
    // }
    
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int K = input.nextInt();

        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();
        
        int[] res = topKFrequent(nums, K);
        
        output.write(Arrays.toString(res));
        
        input.close();
        output.close();
    }
}