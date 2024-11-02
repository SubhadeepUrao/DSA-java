import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int modifiedMerge(int[] a, int lb, int mid, int ub) {
        int i = lb;
        int j = mid+1;
        int inv = 0;
        int[] b = new int[ub - lb + 1];
        int k = 0;

        while(i <= mid && j <= ub) {
            if(a[i] <= a[j]) {
                b[k++] = a[i++];
                inv += j - (mid+1);
            }
            else {
                // inv += mid - i + 1; // a[i] > a[j] i.e. a[i...mid] > a[j] as a[i...mid] is sorted
                b[k++] = a[j++];
            }
        }
        while(i <= mid) {
            b[k++] = a[i++];
            inv += j - (mid+1);
        }
        while(j <= ub) {
            b[k++] = a[j++];
        }

        for(int elem: b) {
            a[lb++] = elem;
        }

        return inv;
    }

    public static int modifiedMergeSort(int[] a, int lb, int ub) {
        if(lb < ub) {
            int mid = (lb + ub) / 2;
            int inv = modifiedMergeSort(a, lb, mid) + modifiedMergeSort(a, mid+1, ub);
            return inv + modifiedMerge(a, lb, mid, ub);
        }
        return 0;
    }
    public static int numberOfInversions(int []a, int n) {
        return modifiedMergeSort(a, 0, n-1);
    }
    
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        FileWriter output = new FileWriter("output.txt");


        int n = input.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; ++i) {
            arr[i] = input.nextInt();
        }

        int inv = numberOfInversions(arr, n);

        output.write(Integer.toString(inv));
        

        input.close();
        output.close();
    }
}