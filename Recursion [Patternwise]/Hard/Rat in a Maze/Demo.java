import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void solve(ArrayList<String> list, int[][] mat, StringBuilder path, int last, int row, int col) {
        int n = mat.length;
        int m = mat[0].length;

        if(mat[row][col] == 0) return;

        if(row == n-1 && col == m-1) {
            list.add(path.toString());
            return;
        }
        
        mat[row][col] = 0;

        if(col > 0) {
            solve(list, mat, path.append('L'), last+1, row, col-1);
            path.setLength(last);
        }
        if(row > 0) {
            solve(list, mat, path.append('U'), last+1, row-1, col);
            path.setLength(last);
        }
        if(col < m-1) {
            solve(list, mat, path.append('R'), last+1, row, col+1);
            path.setLength(last);
        }
        if(row < n-1) {
            solve(list, mat, path.append('D'), last+1, row+1, col);
            path.setLength(last);
        }

        mat[row][col] = 1;

    }
    public static ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> list = new ArrayList<>();
        solve(list, mat, new StringBuilder(), 0, 0, 0);
        return list;
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int m = input.nextInt();
        int[][] mat = new int[n][m];

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < m; ++j)
                mat[i][j] = input.nextInt();
        }


        String res = findPath(mat).toString();

        output.write(res);

        input.close();
        output.close();
        
    }
}
