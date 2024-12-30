class Solution {
    int numDistinct(char[] A, char[] B, int i, int j) {
        if (j < 0) return 1;
        if (i < 0) return 0;

        if (A[i] == B[j])
            return numDistinct(A, B, i - 1, j - 1) + numDistinct(A, B, i - 1, j);
        return numDistinct(A, B, i - 1, j);
    }

    public int numDistinct(String s, String t) {
        int N = s.length();
        int M = t.length();

        return numDistinct(s.toCharArray(), t.toCharArray(), N - 1, M - 1);
    }
}