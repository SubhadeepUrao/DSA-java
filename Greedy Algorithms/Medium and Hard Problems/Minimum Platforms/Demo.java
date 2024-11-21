import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int arrPtr = 0;
        int depPtr = 0;
        int n = arr.length;
        int maxi = 0;
        int cnt = 0;
        
        while(arrPtr < n) {
            if(arr[arrPtr] <= dep[depPtr]) {
                cnt++;
                arrPtr++;
            }
            else {
                cnt--;
                depPtr++;
            }
            maxi = Math.max(maxi, cnt);
        }
        return maxi;
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i)
            arr[i] = input.nextInt();
        int[] dep = new int[n];
        for(int i = 0; i < n; ++i)
            dep[i] = input.nextInt();
        
        int res = findPlatform(arr, dep);
        
        output.write(Integer.toString(res));
        
        input.close();
        output.close();
    }
}