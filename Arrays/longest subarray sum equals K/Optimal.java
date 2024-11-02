import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


// optimal for (0 <= n) for zero and positives
public class Optimal {
    public static int longSubarraySumK(int[] arr, int k) {
        int left = 0, right = 0;
        int maxLen = 0;
        int sum = arr[0];

        while(right < arr.length) {
            while(left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }
            if(sum == k){
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
            if(right < arr.length) sum += arr[right];
            
        }

        return maxLen;
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int k = input.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        
        output.write(Integer.toString(longSubarraySumK(arr, k)));

        input.close();
        output.close();
        
    }
}
