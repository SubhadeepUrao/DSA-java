import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal1 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int lb = 0;
        int ub = n * m - 1;
        int mid, row, col;

        while(lb <= ub) {
            mid = (lb + ub) >> 1;
            row = mid / m;
            col = mid % m;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) lb = mid + 1;
            else ub = mid - 1;
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int m = input.nextInt();
        int target = input.nextInt();

        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j) {
                matrix[i][j] = input.nextInt();
            }
        }

        boolean res = searchMatrix(matrix, target);

        output.write(Boolean.toString(res));

        input.close();
        output.close();
        
    }
}
