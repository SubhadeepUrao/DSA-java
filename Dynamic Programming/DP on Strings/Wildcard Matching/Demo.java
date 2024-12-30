class Solution {
    boolean isMatch(char[] A, char[] B, int i, int j) {
        if (i < 0) {
            if (j < 0) return true;
            while (j >= 0) {
                if (B[j] != '*') return false;
                --j;
            }
            return true;
        }
        if (j < 0) return false;

        if (A[i] == B[j] || B[j] == '?')
            return isMatch(A, B, i - 1, j - 1);
        else if (B[j] == '*')
            return isMatch(A, B, i - 1, j) || isMatch(A, B, i, j - 1);
        return false;
    }

    public boolean isMatch(String s, String p) {
        int N = s.length();
        int M = p.length();
        return isMatch(s.toCharArray(), p.toCharArray(), N - 1, M - 1);
    }
}