import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Better {
    
    public static double findMedian(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;

        int right = (n + m) / 2;
        int left = right - 1;

        int leftVal = 0;
        int rightVal = 0;
        int cnt = 0;

        while(i < n && j < m) {
            if(nums1[i] <= nums2[j]) {
                if(cnt == left) leftVal = nums1[i];
                if(cnt == right) rightVal = nums1[i];
                i++;
            }
            else {
                if(cnt == left) leftVal = nums2[j];
                if(cnt == right) rightVal = nums2[j];
                j++;
            }
            cnt++;
        }

        while(i < n) {
            if(cnt == left) leftVal = nums1[i];
            if(cnt == right) rightVal = nums1[i];
            i++;
            cnt++;
        }
        while(j < m) {
            if(cnt == left) leftVal = nums2[j];
            if(cnt == right) rightVal = nums2[j];
            j++;
            cnt++;
        }

        if((n+m) % 2 == 0) return (leftVal + rightVal) / 2.0;
        return rightVal;
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
