import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal {
    
    // Elimination
    public static int celebrity(int mat[][]) {
        int top = 0;
        int down = mat.length-1;

        while(top < down) {
            if(mat[top][down] == 1) ++top;
            else if(mat[down][top] == 1) --down;
            else {
                ++top;
                --down;
            }
        }
        if(top == down) {
            for(int i = 0; i < mat.length; ++i)
                if(top != i && (mat[top][i] == 1 || mat[i][top] == 0)) return -1;
            return top;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();

        int[][] matrix = new int[N][N];
        for(int i = 0; i < N; ++i)
            for(int j = 0; j < N; ++j)
                matrix[i][j] = input.nextInt();
        
        int res = celebrity(matrix);

        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}