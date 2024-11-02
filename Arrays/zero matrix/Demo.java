import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static void zeroMatrix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int col = 0;
        
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                if(arr[i][j] == 0){
                    arr[i][0] = 0;
                    if(j != 0)
                        arr[0][j] = 0;
                    else 
                        col = 1;
                }
                
            }
        }
        for(int j = 1; j < m; ++j) {
            if(arr[0][j] == 0) {
                for(int i = 1; i < n; ++i)
                    arr[i][j] = 0;
            }
        }
        for(int i = 0; i < n; ++i) {
            if(arr[i][0] == 0) {
                for(int j = 1; j < m; ++j)
                    arr[i][j] = 0;
            }
        }
        
        if(col == 1) {
            for(int i = 0; i < n; ++i)
                arr[i][0] = 0;
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

        zeroMatrix(arr);
        
        for(int[] row : arr) {
            for(int elem : row)
                output.write(Integer.toString(elem) + " ");
            output.write("\n");
        }

        input.close();
        output.close();
        
    }
}
