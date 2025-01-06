class Solution {
    public static int largestRectangleArea(char[] heights, int[] dp) {
        int N = heights.length;
        int[] stack = new int[N + 1];
        int top = -1;
        int maxi = 0;
        int curr;

        for (int i = 0; i <= N; ++i) {
            if (i != N)
                curr = dp[i] = heights[i] == '1' ? dp[i] + 1 : 0;
            else
                curr = 0;

            while (top != -1 && dp[stack[top]] > curr) {
                int height = dp[stack[top--]];
                int width = top == -1 ? i : i - stack[top] - 1;
                maxi = Math.max(maxi, height * width);
            }
            stack[++top] = i;
        }
        return maxi;
    }

    public int maximalRectangle(char[][] matrix) {
        int maxi = 0;
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            maxi = Math.max(maxi, largestRectangleArea(matrix[i], dp));
        }
        return maxi;
    }
}