import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Optimal {
    public static boolean insertValid(boolean[][] board, int row, int col) {
        int n = board.length;
        for(int i = 1; i <= col; ++i) {
            if( (row-i >= 0 && board[row-i][col-i]) ||
                board[row][col-i] ||
                (row+i < n && board[row+i][col-i]))
                return false;
        }
        return true;
    }
    public static void solve(List<List<String>> list, boolean[][] board, int col) {
        int n = board.length;
        if(col == n) {
            // list.add(Arrays.stream(board)
            //                 .map(StringBuilder::toString)
            //                 .toList());
            list.add(constructBoard(board));
            return;
        }
        for(int row = 0; row < n; ++row) {
            if(insertValid(board, row, col)) {
                board[row][col] = true;
                solve(list, board, col+1);
                board[row][col] = false;
            }
        }
    }

    public static List<String> constructBoard(boolean[][] board) {
        List<String> sublist = new ArrayList<>();
        int n = board.length;
        for(int i = 0; i < n; ++i) {
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < n; ++j) {
                if(board[i][j]) str.append('Q');
                else str.append('.');
            }
            sublist.add(str.toString());
        }
        return sublist;
    }

    public static List<List<String>> solveNQueens(int n) {

        boolean[][] board = new boolean[n][n];
        
        List<List<String>> list = new ArrayList<>();
        solve(list, board, 0);
        return list;
    }

    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        String res = solveNQueens(n).toString();

        output.write(res);

        input.close();
        output.close();
        
    }
}
