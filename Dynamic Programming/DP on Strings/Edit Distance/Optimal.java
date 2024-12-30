class Solution {
    public int minDistance(String word1, String word2) {
        int N = word1.length();
        int M = word2.length();
        int[] prev = new int[M + 1];
        char[] A = word1.toCharArray();
        char[] B = word2.toCharArray();

        for (int j = 1; j <= M; ++j)
            prev[j] = j;

        for (int i = 1; i <= N; ++i) {
            int diagonal = i - 1;
            prev[0] = i;
            for (int j = 1; j <= M; ++j) {
                int temp = prev[j];
                prev[j] = A[i - 1] == B[j - 1] ? diagonal : 1 + Math.min(diagonal, Math.min(prev[j], prev[j - 1]));
                diagonal = temp;
            }
        }
        return prev[M];
    }
}