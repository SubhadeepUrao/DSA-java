import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static boolean isValid(char[][] board, int row, int col, char currCh) {
        for(int i = 0; i < 9; ++i) {
            if(board[row][i] == currCh || board[i][col] == currCh) return false;
        }
        int startX = (row/3) * 3;
        int endX = startX + 3;
        int startY = (col/3) * 3;
        int endY = startY + 3;
        for(int i = startX; i < endX; ++i) {
            for(int j = startY; j < endY; ++j) {
                if(board[i][j] == currCh) return false;
            }
        }
        return true;
    }
    public static boolean solve(char[][] board, int row, int col) {
        
        if(col == 9) {
            ++row;
            if(row == 9) return true;        
            col = 0;
        }

        if(board[row][col] == '.') {
            for(char i = '1'; i <= '9'; ++i) {
                if(isValid(board, row, col, i)) {
                    board[row][col] = i;
                    if(solve(board, row, col+1)) return true;
                    board[row][col] = '.';
                }
            }
        }
        else
            return solve(board, row, col+1);
        return false;
    }
    public static void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");
        
        char[][] board = new char[9][9];

        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 9; ++j) {
                board[i][j] = input.next().charAt(0);
            }
        }

        solveSudoku(board);

        for(int i = 0; i < 9; ++i) {
            for(int j = 0; j < 9; ++j) {
                output.write(board[i][j]+" ");
            }
            output.write('\n');
        }

        input.close();
        output.close();

    }
}
