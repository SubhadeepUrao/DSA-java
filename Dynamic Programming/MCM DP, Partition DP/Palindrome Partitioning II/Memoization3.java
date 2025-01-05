class Solution {
    boolean isPalindrome(char[] str, int i, int j) {
        while (i < j && str[i] == str[j]) {
            ++i;
            --j;
        }
        return i >= j ? true : false;
    }

    int minCut(char[] str, int i, int j, Integer[] dp) {
        if (i == j)
            return 0;

        if (dp[i] != null)
            return dp[i];

        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j; ++k) {
            if (isPalindrome(str, i, k))
                mini = Math.min(mini, minCut(str, k + 1, j, dp));
        }
        return dp[i] = mini + 1;
    }

    public int minCut(String s) {
        int N = s.length();
        Integer[] dp = new Integer[N + 1];
        return minCut(s.toCharArray(), 0, N, dp) - 1;
    }
}