class Solution {
    int cutRod(int[] price, int i, int length, Integer[][] dp) {
        if (i == 0 || length == 0) return 0;

        if(dp[i][length] != null) return dp[i][length];

        if (length >= i)
            return dp[i][length] = Math.max(cutRod(price, i, length - i, dp) + price[i-1], cutRod(price, i - 1, length, dp));
        return dp[i][length] = cutRod(price, i - 1, length, dp);
    }

    public int cutRod(int[] price) {
        int N = price.length;
        Integer[][] dp = new Integer[N+1][N+1];
        return cutRod(price, N, N, dp);
    }
}