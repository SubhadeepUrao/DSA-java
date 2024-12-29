class Solution {
    int longestCommonSubsequence(char[] A, char[] B, int i, int j) {
        if (i < 0 || j < 0) return 0;

        if (A[i] == B[j])
            return longestCommonSubsequence(A, B, i - 1, j - 1) + 1;
        return Math.max(longestCommonSubsequence(A, B, i - 1, j), longestCommonSubsequence(A, B, i, j - 1));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int N = text1.length();
        int M = text2.length();
        return longestCommonSubsequence(text1.toCharArray(), text2.toCharArray(), N - 1, M - 1);
    }
}