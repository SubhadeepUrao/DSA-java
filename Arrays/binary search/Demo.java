import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static String binarySearch(int[] arr, int lb, int ub, int target) {
        if(lb < ub - 1) {
            int mid = (lb + ub) / 2;
            if(arr[mid] == target) return "Found";
            else if(arr[mid] > target) return binarySearch(arr, lb, mid, target);
            else return binarySearch(arr, mid + 1, ub, target);
        }
        if(arr[lb] == target) return "Found";
        return "Not Found";
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        input.nextInt();
        int size = 0;
        while(input.hasNextInt()) {
            input.next();
            size++;
        }
        input.close();

        input = new Scanner(inputfile);
        int[] arr = new int[size];
        int i = 0;
        int target = input.nextInt();
        while(input.hasNextInt()) {
            arr[i] = input.nextInt();
            i++;
        }
        // System.out.println(size);
        output.write(binarySearch(arr, 0, size, target)); 

        input.close();
        output.close();
        
    }

}
