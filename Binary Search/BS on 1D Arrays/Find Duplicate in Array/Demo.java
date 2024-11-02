import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    //range: [1...(n-1)]
    public static int findDuplicate(int[] arr) {
        // int lb = 1;
        // int ub = n - 1;
        // while(lb <= ub){
        //     int mid = (lb + ub)/2;
        //     int count = 0;
        //     for(int num: arr){
        //         if(num<=mid) count++;
        //     }
        //     if(count > mid) {
        //         ub = mid-1;
        //     }else {
        //         lb= mid+1;
        //     }
        // }
        // return lb;
        int curr = 0;
        int index;
        while(true) {
            if(arr[curr] < 0) return curr;
            index = arr[curr];
            arr[curr] *= -1;
            curr = index;
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = input.nextInt();
        }

        int res = findDuplicate(arr);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
