class Solution {
    public int numDistinct(String s, String t) {
        int N = s.length();
        int M = t.length();
        int[] prev = new int[M + 1];
        char[] A = s.toCharArray();
        char[] B = t.toCharArray();

        for (int i = 1; i <= N; ++i) {
            int diagonal = 1;
            for (int j = 1; j <= M; ++j) {
                int temp = prev[j];
                prev[j] = A[i - 1] == B[j - 1] ? diagonal + prev[j] : prev[j];
                diagonal = temp;
            }
        }

        return prev[M];
    }
}