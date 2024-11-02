import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal {
    
    public static double findMedian(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if(n > m) return findMedian(nums2, nums1);

        int lb = 0;
        int ub = n;

        int mid1;
        int mid2;

        int left = (n + m + 1) / 2;

        while(lb <= ub) {
            mid1 = (lb + ub) / 2;
            mid2 = left - mid1;

            int l1 = (mid1 > 0)? nums1[mid1-1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0)? nums2[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n)? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < m)? nums2[mid2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1) {
                if((n+m) % 2 == 0) return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else return Math.max(l1, l2);
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
        int m = input.nextInt();

        int[] nums1 = new int[n];
        for(int i = 0; i < n; ++i)
            nums1[i] = input.nextInt();

        int[] nums2 = new int[m];
        for(int i = 0; i < m; ++i)
            nums2[i] = input.nextInt();

        double res = findMedian(nums1, nums2);

        output.write(Double.toString(res));

        input.close();
        output.close();
        
    }
}
