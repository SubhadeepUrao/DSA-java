import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int find(int[] arr, int lb, int ub) {
        if(lb > ub) return 0;
        if(lb == ub) return lb;

        int mid = (lb + ub) / 2;
        // when element next to mid element is smaller
        if(mid < ub && arr[mid] > arr[mid+1]) return mid+1;
        // when element preceding mid element is greater
        if(mid > lb && arr[mid-1] > arr[mid]) return mid;

        // find the part where dipping(N) exists i.e opposite of increasing(/)
        if(arr[mid] < arr[ub]) return find(arr, lb, mid-1);


        return find(arr, mid+1, ub);
    }

    public static int numberOfRotations(int[] arr) {
        return find(arr, 0, arr.length-1);
    }
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int size = input.nextInt();
        // int x = input.nextInt();
        
        int[] arr = new int[size];
        for(int i = 0; i < size; ++i) {
            arr[i] = input.nextInt();
        }

        int res = numberOfRotations(arr);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}

