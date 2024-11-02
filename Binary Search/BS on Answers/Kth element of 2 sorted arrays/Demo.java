import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    
    public static int findKthElement(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        if(n > m) return findKthElement(nums2, nums1, k);

        int lb = Math.max(0, k - m);
        int ub = Math.min(k, n);

        int mid1;
        int mid2;

        while(lb <= ub) {
            mid1 = (lb + ub) >> 1;
            mid2 = k - mid1;

            int l1 = (mid1 > 0)? nums1[mid1-1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0)? nums2[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n)? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < m)? nums2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if(l1 <= r2) lb = mid1 + 1;
            else ub = mid1 - 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] nums1 = new int[n];
        for(int i = 0; i < n; ++i)
            nums1[i] = input.nextInt();
            
        int m = input.nextInt();
        int[] nums2 = new int[m];
        for(int i = 0; i < m; ++i)
            nums2[i] = input.nextInt();

        int k = input.nextInt();

        Integer res = findKthElement(nums1, nums2, k);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
