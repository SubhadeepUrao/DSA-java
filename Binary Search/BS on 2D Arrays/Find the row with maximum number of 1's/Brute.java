import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Brute {
    
    public static int rowMaxOnes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean allOnes = true;
        int maxi = 0;
        int maxRow = -1;

        for(int i = 0; i < n; ++i) {
            int cnt = 0;
            for(int j = 0; j < m; ++j) {
                cnt += matrix[i][j];
            }
            if(cnt < m) allOnes = false;
            if(cnt > maxi) {
                maxi = cnt;
                maxRow = i;
            }
        }
        if(allOnes) return -1;
        return maxRow;
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

        int res = rowMaxOnes(matrix);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
