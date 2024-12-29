class Solution {
    int longestPalindromeSubseq(char[] str, int left, int right) {
        if (left > right) return 0;
        if (left == right) return 1;

        if (str[left] == str[right])
            return 2 + longestPalindromeSubseq(str, left + 1, right - 1);
        return Math.max(longestPalindromeSubseq(str, left, right - 1), longestPalindromeSubseq(str, left + 1, right));
    }

    public int longestPalindromeSubseq(String s) {
        int N = s.length();
        char[] str = s.toCharArray();
        return longestPalindromeSubseq(str, 0, N - 1);
    }
}