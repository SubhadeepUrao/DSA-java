import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal2 {
    public static void swapIfGreater(int[] a, int[] b, int left, int right) {
        if(a[left] > b[right]) {
            int temp = a[left];
            a[left] = b[right];
            b[right] = temp;
        }
    }

    public static void mergeTwoSortedArraysWithoutExtraSpace(int[] a, int[] b) {

        int m = a.length;
        int n = b.length;
        int len = m + n;

        int gap = len / 2 + len % 2;

        while(gap > 0){  
            int left = 0;
            int right = left + gap;

            while(right < len) {
                // left is in a[] and right is in b[]
                if(left < m && right >= m) {
                    swapIfGreater(a, b, left, right-m);
                }
                // both left & right are in a[]
                else if(right < m) {
                    swapIfGreater(a, a, left, right);
                }
                // both left & right are in b[]
                else {
                    swapIfGreater(b, b, left-m, right-m);
                } 
                left++;
                right++;   
            }
            
            if(gap == 1) break;

            gap = gap / 2 + gap % 2;
        }
    }
    
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        FileWriter output = new FileWriter("output.txt");

        int m = input.nextInt();
        int[] arr1 = new int[m];

        for(int i = 0; i < m; ++i) {
            arr1[i] = input.nextInt();
        }

        int n = input.nextInt();
        int[] arr2 = new int[n];

        for(int i = 0; i < n; ++i) {
            arr2[i] = input.nextInt();
        }

        mergeTwoSortedArraysWithoutExtraSpace(arr1, arr2);

        for(int elem: arr1)
            output.write(elem + " ");
        for(int elem: arr2)
            output.write(elem + " ");

        

        input.close();
        output.close();
    }
}