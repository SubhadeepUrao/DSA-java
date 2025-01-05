// Front Partition
class Solution {
    boolean isPalindrome(char[] str, int i, int j) {
        while (i < j && str[i] == str[j]) {
            ++i;
            --j;
        }
        return i >= j ? true : false;
    }

    int minCut(char[] str, int i, int j) {
        if (i == j)
            return 0;

        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j; ++k) {
            if (isPalindrome(str, i, k))
                mini = Math.min(mini, minCut(str, k + 1, j));
        }
        return mini + 1;
    }

    public int minCut(String s) {
        int N = s.length();
        return minCut(s.toCharArray(), 0, N) - 1;
    }
}