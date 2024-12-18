import java.util.Arrays;

class Solution {
    public void shortestDistance(int[][] mat) {
        int N = mat.length;
        int MAX = Integer.MAX_VALUE;
        
        for (int row = 0; row < N; ++row) {
            int i = row; // Effective final variable
            Arrays.setAll(mat[row], j -> mat[i][j] == -1 ? MAX : mat[i][j]); // lambda func works only with final or effective final variable
        }

        for(int k = 0; k < N; ++k) {
            for(int i = 0; i < N; ++i)
                for(int j = 0; j < N; ++j) {
                    if(mat[i][k] != MAX && mat[k][j] != MAX)
                        mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
        }
        
        for (int row = 0; row < N; ++row) {
            int i = row;
            Arrays.setAll(mat[row], j -> mat[i][j] == MAX ? -1 : mat[i][j]);
        }
    }
}