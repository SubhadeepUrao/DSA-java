import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    // time complexity: n * log m
    public static int[] findPeakGrid(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int lb = 0;
        int ub = m-1;
        int mid;

        while(lb <= ub) {
            mid = (lb + ub) >> 1;

            int maxi = 0;
            for(int i = 0; i < n; ++i) {
                if(matrix[maxi][mid] < matrix[i][mid]) maxi = i;
            }

            if((mid == 0 || matrix[maxi][mid-1] < matrix[maxi][mid]) && (mid == m-1 || matrix[maxi][mid] >  matrix[maxi][mid+1]))
                return new int[] {maxi, mid};
            else if(mid > 0 && matrix[maxi][mid-1] > matrix[maxi][mid]) ub = mid - 1;
            else lb = mid + 1;
        }
        return new int[] {-1, -1};
    }
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int m = input.nextInt();

        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                matrix[i][j] = input.nextInt();
            }
        }

        int[] res = findPeakGrid(matrix);

        output.write("[" + res[0] + ", " + res[1] + "]");

        input.close();
        output.close();
        
    }
}
