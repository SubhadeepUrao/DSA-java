import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static void colReverse(int[][] arr, int col) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            int temp = arr[start][col];
            arr[start][col] = arr[end][col];
            arr[end][col] = temp;
            start++;
            end--;
        }
    }
    public static void rotate90degree(int[][] arr) {
        int n = arr.length-1;
        for(int i = 0; i <= n; ++i) {
            int limit = n-i;
            for(int j = 0; j < limit; ++j) {
                int temp = arr[i][j];
                arr[i][j] = arr[n-j][limit];
                arr[n-j][limit] = temp;
            }
        }
        for(int j = 0; j <= n; ++j) {
            colReverse(arr, j);
        }
    }
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int m = input.nextInt();

        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++)
                arr[i][j] = input.nextInt();
        }

        rotate90degree(arr);
        
        for(int[] row : arr) {
            for(int elem : row)
                output.write(Integer.toString(elem) + " ");
            output.write("\n");
        }

        input.close();
        output.close();
        
    }
}
