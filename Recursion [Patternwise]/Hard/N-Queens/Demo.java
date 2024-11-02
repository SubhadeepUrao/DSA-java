import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo {
    // public static boolean insertValid(StringBuilder[] board, int row, int col) {
    //     int duprow = row;
    //     int dupcol = col;
    //     while (row >= 0 && col >= 0) {
    //         if (board[row].charAt(col) == 'Q') return false;
    //         row--;
    //         col--;
    //     }

    //     row = duprow;
    //     col = dupcol;
    //     while (col >= 0) {
    //         if (board[row].charAt(col) == 'Q') return false;
    //         col--;
    //     }

    //     row = duprow;
    //     col = dupcol;
    //     while (col >= 0 && row < board.length) {
    //         if (board[row].charAt(col) == 'Q') return false;
    //         col--;
    //         row++;
    //     }
    //     return true;
    // }
    public static boolean insertValid(StringBuilder[] board, int row, int col) {
        int n = board.length;
        for(int i = 1; i <= col; ++i) {
            if( (row-i >= 0 && board[row-i].charAt(col-i) == 'Q') ||
                board[row].charAt(col-i) == 'Q' ||
                (row+i < n && board[row+i].charAt(col-i) == 'Q'))
                return false;
        }
        return true;
    }
    public static void gen(List<List<String>> list, StringBuilder[] board, int n, int col) {
        if(col == n) {
            list.add(Arrays.stream(board)
                            .map(StringBuilder::toString)
                            .toList());
            return;
        }
        for(int row = 0; row < n; ++row) {
            // if(insertValid(board, n, row, col)) {
            if(insertValid(board, row, col)) {
                board[row].setCharAt(col, 'Q');
                gen(list, board, n, col+1);
                board[row].setCharAt(col, '.');
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {

        StringBuilder[] board = new StringBuilder[n];

        for(int i = 0; i < n; ++i) {
            board[i] = new StringBuilder().append(".".repeat(n));
        }
        
        List<List<String>> list = new ArrayList<>();
        gen(list, board, n, 0);
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
