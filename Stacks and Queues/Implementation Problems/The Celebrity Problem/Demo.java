import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    
    public static int celebrity(int mat[][]) {
        for(int i = 0; i < mat.length; ++i) {
            int j;
            for(j = 0; j < mat[0].length; ++j) {
                if(i != j && (mat[i][j] == 1 || mat[j][i] == 0)) {
                    break;
                }
            }
            if(j == mat[0].length) return i;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int M = input.nextInt();

        int[][] matrix = new int[N][M];
        for(int i = 0; i < N; ++i)
            for(int j = 0; j < M; ++j)
                matrix[i][j] = input.nextInt();
        
        int res = celebrity(matrix);

        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}