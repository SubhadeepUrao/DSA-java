class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int N = text1.length();
        int M = text2.length();

        int[] prev = new int[M + 1];
        char[] A = text1.toCharArray();
        char[] B = text2.toCharArray();

        for (int i = 1; i <= N; ++i) {
            int diagonal = 0; // Store the value of prev[j-1] from the previous row
            for (int j = 1; j <= M; ++j) {
                int temp = prev[j]; // Save current prev[j] before overwritten
                prev[j] = A[i - 1] == B[j - 1] ? diagonal + 1 : Math.max(prev[j], prev[j - 1]);
                diagonal = temp; // Update diagonal for the next column
            }
        }

        return prev[M];
    }
    public int minDistance(String word1, String word2) {
        int common = longestCommonSubsequence(word1, word2);
        return word1.length() + word2.length() - (common << 1);
    }
}