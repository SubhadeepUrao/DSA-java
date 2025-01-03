import java.util.Arrays;

class Solution {
    boolean isPredecessor(String A, String B) {
        if (B.length() - A.length() != 1) return false;
        
        int i = 0, j = 0;
        while (i < A.length() && j < B.length()) {
            if (A.charAt(i) == B.charAt(j)) {
                ++i;
                ++j;
            } else
                ++j;
        }
        return i == A.length();
    }

    public int longestStrChain(String[] words) {
        int N = words.length;
        int[] dp = new int[N];

        int maxi = 1;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        dp[0] = 1;

        for (int i = 1; i < N; ++i) {
            int lmax = 0;
            for (int prev = 0; prev < i; ++prev) {
                if (isPredecessor(words[prev], words[i]) && lmax < dp[prev]) {
                    lmax = dp[prev];
                }
            }
            dp[i] = lmax + 1;
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}