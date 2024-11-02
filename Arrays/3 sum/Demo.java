import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> hs = new ArrayList<>();

        for(int i = 0; i < n-2; ++i) {
            int target = -arr[i];
            int left = i + 1;
            int right = n - 1;
            while(left < right) {
                int sum = arr[left] + arr[right];
                if(sum == target) {
                    hs.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                    while(left < right && arr[left] == arr[left-1]) {
                        left++;
                    }
                }
                else if(sum < target) left++;
                else right--;
            }
            while(i+1 < n && arr[i+1] == arr[i]) i++;
        }
        return hs;
    }
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        List<List< Integer >> list = threeSum(arr);

        for(List< Integer > lst : list) {
            for(int elem : lst)
                output.write(elem + " ");
            output.write("\n");
        }

        input.close();
        output.close();
        
    }
}