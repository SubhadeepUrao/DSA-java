import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void findKthLargest(int[] arr, int lb, int ub, int k) {
        int left = lb;
        int right = ub;
        int pivotElem = arr[lb];

        do {
            do {
                left++;
            } while(left < ub && arr[left] < pivotElem);
            do {
                right--;
            } while(right >= lb && pivotElem < arr[right]);

            if(left < right) swap(arr, left, right);
        } while(left < right);

        swap(arr, lb, right);

        int n = arr.length;

        // if(n-k == right) return; // found Kth largest
        if(right < n-k) findKthLargest(arr, right+1, ub, k);
        else if(n-k < right) findKthLargest(arr, lb, right, k);
    }
    
    public static int[] findKLargest(int[] arr, int k) {
        int[] res = new int[k];
        int n = arr.length;

        findKthLargest(arr, 0, n, k);

        for(int i = n-k, j = 0; i < n; ++i, ++j) {
            res[j] = arr[i];
        }
        Arrays.sort(res);
        return res;
    }
    
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int k = input.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = input.nextInt();
        }

        int[] res = findKLargest(arr, k);

        for(int elem: res) {
            output.write(elem + " ");
        }

        input.close();
        output.close();
        
    }
}
