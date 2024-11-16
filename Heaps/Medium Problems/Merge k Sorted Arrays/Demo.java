import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {

    static int[] heapsizeInner;
    
    static int left(int i) { return (i * 2) + 1; }
    static int right(int i) { return (i * 2) + 2; }

    static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void minHeapify(int[][] arr, int i, int heapsizeOuter) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if(l < heapsizeOuter && arr[l][0] < arr[i][0]) smallest = l;
        if(r < heapsizeOuter && arr[r][0] < arr[smallest][0]) smallest = r;

        if(smallest != i) {
            swap(arr, i, smallest);
            swap(heapsizeInner, i, smallest);
            minHeapify(arr, smallest, heapsizeOuter);
        }
    }

    static void minHeapify(int[] arr, int i, int heapsizeInner) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        if(l < heapsizeInner && arr[l] < arr[i]) smallest = l;
        if(r < heapsizeInner && arr[r] < arr[smallest]) smallest = r;

        if(smallest != i) {
            swap(arr, i, smallest);
            minHeapify(arr, smallest, heapsizeInner);
        }
    }
    
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) {
        heapsizeInner = new int[K];
        int heapsizeOuter = K;
        Arrays.fill(heapsizeInner, K);

        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = (K / 2) - 1; i >= 0; --i) 
            minHeapify(arr, i, heapsizeOuter);
        
        int n = K * K;
        for(int i = 0; i < n; ++i) {
            res.add(arr[0][0]);
            
            // System.out.println(arr[0][0] + " >> " + Arrays.toString(heapsizeInner));

            
            swap(arr[0], 0, --heapsizeInner[0]);
            minHeapify(arr[0], 0, heapsizeInner[0]);

            
            // System.out.println(Arrays.toString(arr[0]));

            if(heapsizeInner[0] == 0) {
                swap(arr, 0, --heapsizeOuter);
                swap(heapsizeInner, 0, heapsizeOuter);
            }
            
            minHeapify(arr, 0, heapsizeOuter);

        }

        return res;
    }
    
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();

        int[][] nums = new int[N][N];
        for(int i = 0; i < N; ++i)
            for(int j = 0; j < N; ++j)
                nums[i][j] = input.nextInt();
        
        List<Integer> res = mergeKArrays(nums, N);
        
        output.write(res.toString());
        
        input.close();
        output.close();
    }
}