class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        int N = s1.length();
        int M = s2.length();
        int[] prev = new int[M + 1];
        char[] A = s1.toCharArray();
        char[] B = s2.toCharArray();

        int maxLength = 0;
        for (int i = 1; i <= N; ++i) {
            for (int j = M; j >= 1; --j) {
                prev[j] = A[i - 1] == B[j - 1] ? 1 + prev[j - 1] : 0;
                maxLength = Math.max(maxLength, prev[j]);
            }
        }
        return maxLength;
    }
}