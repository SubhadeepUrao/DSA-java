class Solution {
    int longestCommonSubstr(char[] A, char[] B, int i, int j, int cnt) {
        if(i < 0 || j < 0) return cnt;

        if(A[i] == B[j]) cnt = longestCommonSubstr(A, B, i - 1, j - 1, cnt + 1);
        return Math.max(Math.max(longestCommonSubstr(A, B, i, j - 1, 0), longestCommonSubstr(A, B, i - 1, j, 0)), cnt);
    }

    public int longestCommonSubstr(String s1, String s2) {
        int N = s1.length();
        int M = s2.length();
        return longestCommonSubstr(s1.toCharArray(), s2.toCharArray(), N - 1, M - 1, 0);
    }
}