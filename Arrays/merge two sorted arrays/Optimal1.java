import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Optimal1 {
    public static void mergeTwoSortedArraysWithoutExtraSpace(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        int right = n - 1;
        int left = 0;

        while(right >= 0 && left < m) {
            if(a[right] <= b[left]) break;
            else {
                int temp = a[right];
                a[right] = b[left];
                b[left] = temp;
                right--;
                left++;
            }
        }

        Arrays.sort(a);
        Arrays.sort(b);
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

        for(int i = 0; i < m; ++i)
            output.write(arr1[i] + " ");
        for(int elem: arr2)
            output.write(elem + " ");

        

        input.close();
        output.close();
    }
}