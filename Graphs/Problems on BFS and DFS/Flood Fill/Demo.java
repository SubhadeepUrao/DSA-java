class Solution {
    int M, N;
    int target;
    
    void paint(int i, int j, int[][] image, int color) {
        int[][] moves = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

        for (int[] move : moves) {
            int x = move[0] + i;
            int y = move[1] + j;
            if ((0 <= x && x < M) && (0 <= y && y < N) && image[x][y] != color && image[x][y] == target) {
                image[x][y] = color;
                paint(x, y, image, color);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        M = image.length;
        N = image[0].length;

        target = image[sr][sc];
        image[sr][sc] = color;
        paint(sr, sc, image, color);

        return image;
    }
}