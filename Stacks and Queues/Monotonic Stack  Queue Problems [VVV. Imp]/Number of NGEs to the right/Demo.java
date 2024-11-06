import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {

    static class Pair<K, V> {
        K first;
        V second;
        Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void merge(ArrayList<Pair<Integer, Integer>> list, int[] cntArray, int lb, int mid, int ub) {
        int i = lb;
        int j = mid + 1;

        ArrayList<Pair<Integer, Integer>> temp = new ArrayList<>();

        while (i <= mid && j <= ub) {
            if (list.get(i).first < list.get(j).first) {
                cntArray[list.get(i).second] += ub - j + 1;
                temp.add(list.get(i));
                ++i;
            } else {
                temp.add(list.get(j));
                ++j;
            }
        }

        while (i <= mid) {
            temp.add(list.get(i));
            ++i;
        }
        while (j <= ub) {
            temp.add(list.get(j));
            ++j;
        }

        for (int k = lb; k <= ub; ++k) {
            list.set(k, temp.get(k - lb));
        }
    }

    public static void mergeSort(ArrayList<Pair<Integer, Integer>> list, int[] cntArray, int lb, int ub) {
        if(lb < ub) {
            int mid = (lb + ub) >> 1;
            mergeSort(list, cntArray, lb, mid);
            mergeSort(list, cntArray, mid+1, ub);
            merge(list, cntArray, lb, mid, ub);
        }
    }

    // O(N log N) + O(Q)
    public static int[] countNGEs(int[] nums, int[] queries) {
        int[] cntArray = new int[nums.length];
        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; ++i)
            list.add(new Pair<>(nums[i], i));
        
        mergeSort(list, cntArray, 0, nums.length-1);

        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; ++i)
            res[i] = cntArray[queries[i]];

        return res;
    }


    // O(NQ)
//   public static int[] countNGEs(int N, int arr[], int Q, int queries[]) {
    
//     int[] res = new int[Q];
    
//     for(int i = 0; i < Q; ++i) {
//         int cnt = 0;
//         for(int j = queries[i]+1; j < N; ++j) {
//             if(arr[queries[i]] < arr[j]) cnt++;
//         }
//         res[i] = cnt;
//     }
    
//     return res;
//   }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();
        
        int Q = input.nextInt();
        int[] queries = new int[Q];
        for(int i = 0; i < Q; ++i)
            queries[i] = input.nextInt();

        int[] cntArray = countNGEs(nums, queries);

        output.write(Arrays.toString(cntArray));

        input.close();
        output.close();
    }
}