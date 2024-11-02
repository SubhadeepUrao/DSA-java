// NOTE:
// n -> odd
// m -> odd
// n x m -> odd

// n -> 3 and n -> 5 i.e. no. of elements less than median -> (3 x 5) / 2
// search space =>[1(minElem)...16(maxElem)]
// for any number in this range, we find no. of elem less than that number i.e.
// sum of upperbound(number) in each row

// (no. of elements <= number) > median  ----> condition must satisfy

import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal {
    public static int upperBound(int[] row, int key) {
        int lb = 0;
        int ub = row.length-1;
        int mid;

        while(lb <= ub) {
            mid = (lb + ub) >> 1;
            if(key < row[mid]) ub = mid - 1;
            else lb = mid + 1;
        }
        return lb;
    }
    public static int precedingElementCount(int[][] matrix, int key) {
        int n = matrix.length;
        int cnt = 0;
        for(int i = 0; i < n; ++i) {
            cnt += upperBound(matrix[i], key);
        }
        return cnt;
    }
    public static int findMedian(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i) {
            mini = Math.min(mini, matrix[i][0]);
            maxi = Math.max(maxi, matrix[i][m-1]);
        }

        int lb = mini;
        int ub = maxi;
        int mid;

        int elementsLessThanMedian = (n * m) >> 1;

        while(lb <= ub) {
            mid = (lb + ub) >> 1;
            int precedeElementCnt = precedingElementCount(matrix, mid);
            if(precedeElementCnt <= elementsLessThanMedian) lb = mid + 1;
            else ub = mid - 1;
        }
        return lb;
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

        int res = findMedian(matrix);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
