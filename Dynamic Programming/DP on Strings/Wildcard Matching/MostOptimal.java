class Solution {
    public boolean isMatch(String s, String p) {
        int N = s.length();
        int M = p.length();
        char[] A = s.toCharArray();
        char[] B = p.toCharArray();
        int i = 0, j = 0;
        int lastStarPos = -1, matchStartPos = 0;

        while (i < N) {
            if (j < M && (A[i] == B[j] || B[j] == '?')) {
                ++i;
                ++j;
            } else if (j < M && B[j] == '*') {
                matchStartPos = i;
                lastStarPos = j;
                ++j;
            } else if (lastStarPos != -1) {
                ++matchStartPos;
                i = matchStartPos;
                j = lastStarPos + 1;
            } else
                return false;
        }

        while (j < M && B[j] == '*')
            ++j;

        return j == M;
    }
}