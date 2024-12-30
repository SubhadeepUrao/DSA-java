class Solution {
    public boolean isMatch(String s, String p) {
        int N = s.length();
        int M = p.length();
        boolean[] prev = new boolean[M+1];
        char[] A = s.toCharArray();
        char[] B = p.toCharArray();

        prev[0] = true;
        for(int j = 1; j <= M; ++j)
            if(B[j-1] == '*')
                prev[j] = prev[j-1];

        for (int i = 1; i <= N; ++i) {
            boolean diagonal = prev[0];
            prev[0] = false;
            for (int j = 1; j <= M; ++j) {
                boolean temp = prev[j];
                prev[j] = A[i-1] == B[j-1] || B[j-1] == '?' ? diagonal
                        : B[j-1] == '*' ? prev[j] || prev[j - 1] : false;
                diagonal = temp;
            }
        }

        return prev[M];
    }
}