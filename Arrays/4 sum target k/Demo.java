import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static List<List<Integer>> fourSumK(int[] arr, int n, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0; i < n-3; ++i) {
            if(i > 0 && arr[i] == arr[i-1]) continue;

            for(int j = i+1; j < n-2; ++j) {
                if(j > i+1 && arr[j] == arr[j-1]) continue;

                long k = (long) target - arr[i] - arr[j]; // Explicitly cast k to long
                int left = j + 1;
                int right = n - 1;
                while(left < right) {
                    long sum = (long) arr[left] + arr[right];
                    if(sum == k) {
                        resList.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left++;
                        right--;
                        while(left < right && arr[left] == arr[left-1]) left++;
                        while(left < right && arr[right] == arr[right+1]) right--;
                    }
                    else if(sum < k) left++;
                    else right--;
                }
            }
        }

        return resList;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int k = input.nextInt();
        
        int[] arr = new int[n];

        for(int i = 0; i < n; ++i)
            arr[i] = input.nextInt();
        
        List<List<Integer>> res = fourSumK(arr, n, k);

        if(res.size() == 0) output.write("List empty.");
        for(List<Integer> list: res) {
            for(int elem: list)
                output.write(elem + " ");
            output.write("\n");
        }

        input.close();
        output.close();
    }
}
