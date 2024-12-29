class Solution {
    int longestPalindromeSubseq(char[] str, int left, int right, Integer[][] dp) {
        if (left > right) return 0;
        if (left == right) return 1;

        if(dp[left][right] != null) return dp[left][right];

        if (str[left] == str[right])
            return dp[left][right] = 2 + longestPalindromeSubseq(str, left + 1, right - 1, dp);
        
        return dp[left][right] = Math.max(longestPalindromeSubseq(str, left, right - 1, dp),
                longestPalindromeSubseq(str, left + 1, right, dp));
    }

    public int longestPalindromeSubseq(String s) {
        int N = s.length();
        Integer[][] dp = new Integer[N][N];
        return longestPalindromeSubseq(s.toCharArray(), 0, N - 1, dp);
    }
}