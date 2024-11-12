import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Demo {

    public static int totalFruits(Integer[] arr) {
        int n = arr.length;
        int basketCnt = 2;
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int maxi = 0;
        
        for(;right < n; ++right) {
            if(mpp.containsKey(arr[right]))
                mpp.put(arr[right], mpp.get(arr[right]) + 1);
            else
                mpp.put(arr[right], 1);
                
            if(mpp.size() > basketCnt) {
                mpp.put(arr[left], mpp.get(arr[left]) - 1);
                if(mpp.get(arr[left]) == 0) {
                    mpp.remove(arr[left]);
                }
                left++;
                maxi = Math.max(maxi, right - left + 1);
            }
        }
        return Math.max(maxi, right - left);
    }
    
    // public static int totalFruits(Integer[] arr) {
    //     int n = arr.length;
    //     int basketCnt = 2;
    //     int left = 0;
    //     int right = 0;
    //     HashMap<Integer, Integer> mpp = new HashMap<>();
    //     int maxi = 0;
        
    //     for(;right < n; ++right) {
    //         if(mpp.containsKey(arr[right]))
    //             mpp.put(arr[right], mpp.get(arr[right]) + 1);
    //         else
    //             mpp.put(arr[right], 1);
                
    //         if(mpp.size() > basketCnt) {
    //             mpp.put(arr[left], mpp.get(arr[left]) - 1);
    //             if(mpp.get(arr[left]) == 0) {
    //                 mpp.remove(arr[left]);
    //             }
    //             left++;
    //         }
    //         maxi = Math.max(maxi, right - left + 1);
    //     }
    //     return maxi;
    // }

    // public static int totalFruits(Integer[] arr) {
    //     int n = arr.length;
    //     int basketCnt = 1;
    //     int[] basket = new int[100001];
    //     int first = 0;
    //     int second = 0;
    //     int maxi = 0;
        
    //     for(int i = 0; i < n; ++i) {
    //         if(basketCnt <= 2 && basket[arr[i]] == 0) {
    //             if(basketCnt == 1)
    //                 first = arr[i];
    //             else if(basketCnt == 2)
    //                 second = arr[i];
    //             basketCnt++;
    //         }
    //         else {
    //             if(basket[arr[i]] == 0) {
    //                 maxi = Math.max(maxi, basket[first] + basket[second]);
    //                 basket[first] = 0;
    //                 first = second;
    //                 second = arr[i];
    //             }
    //         }
    //         basket[arr[i]]++;
    //     }
    //     return Math.max(maxi, basket[first] + basket[second]);
    // }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();

        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();

        int res = totalFruits(Arrays.stream(nums)
                                    .boxed()
                                    .toArray(Integer[] :: new));

        output.write(res + "");

        input.close();
        output.close();
    }
}
