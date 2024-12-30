class Solution {
    int minDistance(char[] A, char[] B, int i, int j) {
        if (i < 0) return j + 1; // all inserts
        if (j < 0) return i + 1; // all removals

        if (A[i] == B[j])
            return minDistance(A, B, i - 1, j - 1);
        return 1 + Math.min(minDistance(A, B, i - 1, j - 1),
                Math.min(minDistance(A, B, i - 1, j), minDistance(A, B, i, j - 1)));
    }

    public int minDistance(String word1, String word2) {
        int N = word1.length();
        int M = word2.length();
        return minDistance(word1.toCharArray(), word2.toCharArray(), N - 1, M - 1);
    }
}