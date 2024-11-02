import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static boolean exist(char[][] board, String word, int i, int j, int idx, int m, int n) {
        // Base case: if we've matched all characters in the word
        if (idx == word.length()) return true;

        // Out-of-bounds or invalid match conditions
        if (i < 0 || j < 0 || i == m || j == n || board[i][j] != word.charAt(idx)) {
            return false;
        }

        // Mark the current cell as visited
        board[i][j] ^= 256;

        // Recursively search in all 4 directions (left, up, right, down)
        boolean found = exist(board, word, i, j-1, idx + 1, m, n) || // left
                        exist(board, word, i - 1, j, idx + 1, m, n) || // up
                        exist(board, word, i, j + 1, idx + 1, m, n) || // right
                        exist(board, word, i + 1, j, idx + 1, m, n);   // down

        // Backtrack by unmarking the current cell
        board[i][j] ^= 256;

        return found;
    }

    // Method to check if the word exists in the board
    public static boolean wordSearch(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        // Try to find the word starting from each cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, word, i, j, 0, m, n)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        String str = input.next();

        int m = input.nextInt();
        int n = input.nextInt();

        char[][] board = new char[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                board[i][j] = input.next().charAt(0);
            }
        }

        boolean res = wordSearch(board, str);

        output.write(Boolean.toString(res));

        input.close();
        output.close();
        
    }
}
