class Solution {
    public int longestPalindromeSubseq(String s) {
        int N = s.length();
        int[] prev = new int[N];
        char[] str = s.toCharArray();

        prev[0] = 1;
        int[] curr = new int[N];

        for (int j = 1; j < N; ++j) {
            curr[j] = 1;
            for (int i = j - 1; i >= 0; --i) {
                curr[i] = str[i] == str[j] ? 2 + prev[i + 1] : Math.max(prev[i], curr[i + 1]);
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[0];
    }
    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }
}