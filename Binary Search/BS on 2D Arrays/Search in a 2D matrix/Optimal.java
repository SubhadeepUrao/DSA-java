import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int lb = 0;
        int ub = n - 1;
        int mid = -1;

        while(lb <= ub) {
            mid = (lb + ub) >> 1;
            if(matrix[mid][0] <= target && target <= matrix[mid][m-1]) {
                break;
            }
            else if(target < matrix[mid][0]) ub = mid - 1;
            else lb = mid + 1;
        }
        
        if(lb == n || ub == -1) return false;
        int row = mid;
        lb = 0;
        ub = m - 1;

        while(lb <= ub) {
            mid = (lb + ub) >> 1;
            if(matrix[row][mid] == target) return true;
            else if(target < matrix[row][mid]) ub = mid - 1;
            else lb = mid + 1;
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
