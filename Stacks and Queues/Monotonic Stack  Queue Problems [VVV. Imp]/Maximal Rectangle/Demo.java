import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static int largestRectangleArea(char[] heights, int[] above) {
        int n = heights.length;
        int[] stack = new int[n+1];
        int top = -1;
        int maxi = 0;
        int currHeight;

        for(int i = 0; i <= n; ++i) {
            if(i != n) {
                currHeight = above[i] = heights[i] == '1' ? above[i] + 1 : 0;
            }
            else currHeight = 0;

            while(top != -1 && above[stack[top]] > currHeight) {
                int height = above[stack[top--]];
                int width = top == -1 ? i : i - stack[top] - 1;
                maxi = Math.max(maxi, height * width);
            }
            stack[++top] = i;
        }
        return maxi;
    }

    public static int maximalRectangle(char[][] matrix) {
        int maxi = 0;
        int[] above = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; ++i) {
            maxi = Math.max(maxi, largestRectangleArea(matrix[i], above));
        }
        return maxi;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int M = input.nextInt();

        char[][] matrix = new char[N][M];
        for(int i = 0; i < N; ++i)
            for(int j = 0; j < M; ++j)
                matrix[i][j] = input.next().charAt(0);
        
        int res = maximalRectangle(matrix);

        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}